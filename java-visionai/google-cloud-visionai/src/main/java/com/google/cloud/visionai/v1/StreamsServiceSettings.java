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

package com.google.cloud.visionai.v1;

import static com.google.cloud.visionai.v1.StreamsServiceClient.ListClustersPagedResponse;
import static com.google.cloud.visionai.v1.StreamsServiceClient.ListEventsPagedResponse;
import static com.google.cloud.visionai.v1.StreamsServiceClient.ListSeriesPagedResponse;
import static com.google.cloud.visionai.v1.StreamsServiceClient.ListStreamsPagedResponse;

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
import com.google.cloud.visionai.v1.stub.StreamsServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link StreamsServiceClient}.
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
 * StreamsServiceSettings.Builder streamsServiceSettingsBuilder =
 *     StreamsServiceSettings.newBuilder();
 * streamsServiceSettingsBuilder
 *     .getClusterSettings()
 *     .setRetrySettings(
 *         streamsServiceSettingsBuilder
 *             .getClusterSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * StreamsServiceSettings streamsServiceSettings = streamsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class StreamsServiceSettings extends ClientSettings<StreamsServiceSettings> {

  /** Returns the object with the settings used for calls to listClusters. */
  public PagedCallSettings<ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).listClustersSettings();
  }

  /** Returns the object with the settings used for calls to getCluster. */
  public UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).getClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).createClusterSettings();
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).createClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).updateClusterSettings();
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).updateClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).deleteClusterSettings();
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).deleteClusterOperationSettings();
  }

  /** Returns the object with the settings used for calls to listStreams. */
  public PagedCallSettings<ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>
      listStreamsSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).listStreamsSettings();
  }

  /** Returns the object with the settings used for calls to getStream. */
  public UnaryCallSettings<GetStreamRequest, Stream> getStreamSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).getStreamSettings();
  }

  /** Returns the object with the settings used for calls to createStream. */
  public UnaryCallSettings<CreateStreamRequest, Operation> createStreamSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).createStreamSettings();
  }

  /** Returns the object with the settings used for calls to createStream. */
  public OperationCallSettings<CreateStreamRequest, Stream, OperationMetadata>
      createStreamOperationSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).createStreamOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateStream. */
  public UnaryCallSettings<UpdateStreamRequest, Operation> updateStreamSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).updateStreamSettings();
  }

  /** Returns the object with the settings used for calls to updateStream. */
  public OperationCallSettings<UpdateStreamRequest, Stream, OperationMetadata>
      updateStreamOperationSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).updateStreamOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteStream. */
  public UnaryCallSettings<DeleteStreamRequest, Operation> deleteStreamSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).deleteStreamSettings();
  }

  /** Returns the object with the settings used for calls to deleteStream. */
  public OperationCallSettings<DeleteStreamRequest, Empty, OperationMetadata>
      deleteStreamOperationSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).deleteStreamOperationSettings();
  }

  /** Returns the object with the settings used for calls to getStreamThumbnail. */
  public UnaryCallSettings<GetStreamThumbnailRequest, Operation> getStreamThumbnailSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).getStreamThumbnailSettings();
  }

  /** Returns the object with the settings used for calls to getStreamThumbnail. */
  public OperationCallSettings<
          GetStreamThumbnailRequest, GetStreamThumbnailResponse, OperationMetadata>
      getStreamThumbnailOperationSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).getStreamThumbnailOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateStreamHlsToken. */
  public UnaryCallSettings<GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>
      generateStreamHlsTokenSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).generateStreamHlsTokenSettings();
  }

  /** Returns the object with the settings used for calls to listEvents. */
  public PagedCallSettings<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      listEventsSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).listEventsSettings();
  }

  /** Returns the object with the settings used for calls to getEvent. */
  public UnaryCallSettings<GetEventRequest, Event> getEventSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).getEventSettings();
  }

  /** Returns the object with the settings used for calls to createEvent. */
  public UnaryCallSettings<CreateEventRequest, Operation> createEventSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).createEventSettings();
  }

  /** Returns the object with the settings used for calls to createEvent. */
  public OperationCallSettings<CreateEventRequest, Event, OperationMetadata>
      createEventOperationSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).createEventOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateEvent. */
  public UnaryCallSettings<UpdateEventRequest, Operation> updateEventSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).updateEventSettings();
  }

  /** Returns the object with the settings used for calls to updateEvent. */
  public OperationCallSettings<UpdateEventRequest, Event, OperationMetadata>
      updateEventOperationSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).updateEventOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEvent. */
  public UnaryCallSettings<DeleteEventRequest, Operation> deleteEventSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).deleteEventSettings();
  }

  /** Returns the object with the settings used for calls to deleteEvent. */
  public OperationCallSettings<DeleteEventRequest, Empty, OperationMetadata>
      deleteEventOperationSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).deleteEventOperationSettings();
  }

  /** Returns the object with the settings used for calls to listSeries. */
  public PagedCallSettings<ListSeriesRequest, ListSeriesResponse, ListSeriesPagedResponse>
      listSeriesSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).listSeriesSettings();
  }

  /** Returns the object with the settings used for calls to getSeries. */
  public UnaryCallSettings<GetSeriesRequest, Series> getSeriesSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).getSeriesSettings();
  }

  /** Returns the object with the settings used for calls to createSeries. */
  public UnaryCallSettings<CreateSeriesRequest, Operation> createSeriesSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).createSeriesSettings();
  }

  /** Returns the object with the settings used for calls to createSeries. */
  public OperationCallSettings<CreateSeriesRequest, Series, OperationMetadata>
      createSeriesOperationSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).createSeriesOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateSeries. */
  public UnaryCallSettings<UpdateSeriesRequest, Operation> updateSeriesSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).updateSeriesSettings();
  }

  /** Returns the object with the settings used for calls to updateSeries. */
  public OperationCallSettings<UpdateSeriesRequest, Series, OperationMetadata>
      updateSeriesOperationSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).updateSeriesOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteSeries. */
  public UnaryCallSettings<DeleteSeriesRequest, Operation> deleteSeriesSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).deleteSeriesSettings();
  }

  /** Returns the object with the settings used for calls to deleteSeries. */
  public OperationCallSettings<DeleteSeriesRequest, Empty, OperationMetadata>
      deleteSeriesOperationSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).deleteSeriesOperationSettings();
  }

  /** Returns the object with the settings used for calls to materializeChannel. */
  public UnaryCallSettings<MaterializeChannelRequest, Operation> materializeChannelSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).materializeChannelSettings();
  }

  /** Returns the object with the settings used for calls to materializeChannel. */
  public OperationCallSettings<MaterializeChannelRequest, Channel, OperationMetadata>
      materializeChannelOperationSettings() {
    return ((StreamsServiceStubSettings) getStubSettings()).materializeChannelOperationSettings();
  }

  public static final StreamsServiceSettings create(StreamsServiceStubSettings stub)
      throws IOException {
    return new StreamsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return StreamsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return StreamsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return StreamsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return StreamsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return StreamsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return StreamsServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return StreamsServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return StreamsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected StreamsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for StreamsServiceSettings. */
  public static class Builder extends ClientSettings.Builder<StreamsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(StreamsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(StreamsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(StreamsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(StreamsServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(StreamsServiceStubSettings.newHttpJsonBuilder());
    }

    public StreamsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((StreamsServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listClusters. */
    public PagedCallSettings.Builder<
            ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
        listClustersSettings() {
      return getStubSettingsBuilder().listClustersSettings();
    }

    /** Returns the builder for the settings used for calls to getCluster. */
    public UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings() {
      return getStubSettingsBuilder().getClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings() {
      return getStubSettingsBuilder().createClusterSettings();
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public OperationCallSettings.Builder<CreateClusterRequest, Cluster, OperationMetadata>
        createClusterOperationSettings() {
      return getStubSettingsBuilder().createClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings() {
      return getStubSettingsBuilder().updateClusterSettings();
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public OperationCallSettings.Builder<UpdateClusterRequest, Cluster, OperationMetadata>
        updateClusterOperationSettings() {
      return getStubSettingsBuilder().updateClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings() {
      return getStubSettingsBuilder().deleteClusterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public OperationCallSettings.Builder<DeleteClusterRequest, Empty, OperationMetadata>
        deleteClusterOperationSettings() {
      return getStubSettingsBuilder().deleteClusterOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listStreams. */
    public PagedCallSettings.Builder<
            ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>
        listStreamsSettings() {
      return getStubSettingsBuilder().listStreamsSettings();
    }

    /** Returns the builder for the settings used for calls to getStream. */
    public UnaryCallSettings.Builder<GetStreamRequest, Stream> getStreamSettings() {
      return getStubSettingsBuilder().getStreamSettings();
    }

    /** Returns the builder for the settings used for calls to createStream. */
    public UnaryCallSettings.Builder<CreateStreamRequest, Operation> createStreamSettings() {
      return getStubSettingsBuilder().createStreamSettings();
    }

    /** Returns the builder for the settings used for calls to createStream. */
    public OperationCallSettings.Builder<CreateStreamRequest, Stream, OperationMetadata>
        createStreamOperationSettings() {
      return getStubSettingsBuilder().createStreamOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateStream. */
    public UnaryCallSettings.Builder<UpdateStreamRequest, Operation> updateStreamSettings() {
      return getStubSettingsBuilder().updateStreamSettings();
    }

    /** Returns the builder for the settings used for calls to updateStream. */
    public OperationCallSettings.Builder<UpdateStreamRequest, Stream, OperationMetadata>
        updateStreamOperationSettings() {
      return getStubSettingsBuilder().updateStreamOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteStream. */
    public UnaryCallSettings.Builder<DeleteStreamRequest, Operation> deleteStreamSettings() {
      return getStubSettingsBuilder().deleteStreamSettings();
    }

    /** Returns the builder for the settings used for calls to deleteStream. */
    public OperationCallSettings.Builder<DeleteStreamRequest, Empty, OperationMetadata>
        deleteStreamOperationSettings() {
      return getStubSettingsBuilder().deleteStreamOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getStreamThumbnail. */
    public UnaryCallSettings.Builder<GetStreamThumbnailRequest, Operation>
        getStreamThumbnailSettings() {
      return getStubSettingsBuilder().getStreamThumbnailSettings();
    }

    /** Returns the builder for the settings used for calls to getStreamThumbnail. */
    public OperationCallSettings.Builder<
            GetStreamThumbnailRequest, GetStreamThumbnailResponse, OperationMetadata>
        getStreamThumbnailOperationSettings() {
      return getStubSettingsBuilder().getStreamThumbnailOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateStreamHlsToken. */
    public UnaryCallSettings.Builder<GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>
        generateStreamHlsTokenSettings() {
      return getStubSettingsBuilder().generateStreamHlsTokenSettings();
    }

    /** Returns the builder for the settings used for calls to listEvents. */
    public PagedCallSettings.Builder<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
        listEventsSettings() {
      return getStubSettingsBuilder().listEventsSettings();
    }

    /** Returns the builder for the settings used for calls to getEvent. */
    public UnaryCallSettings.Builder<GetEventRequest, Event> getEventSettings() {
      return getStubSettingsBuilder().getEventSettings();
    }

    /** Returns the builder for the settings used for calls to createEvent. */
    public UnaryCallSettings.Builder<CreateEventRequest, Operation> createEventSettings() {
      return getStubSettingsBuilder().createEventSettings();
    }

    /** Returns the builder for the settings used for calls to createEvent. */
    public OperationCallSettings.Builder<CreateEventRequest, Event, OperationMetadata>
        createEventOperationSettings() {
      return getStubSettingsBuilder().createEventOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateEvent. */
    public UnaryCallSettings.Builder<UpdateEventRequest, Operation> updateEventSettings() {
      return getStubSettingsBuilder().updateEventSettings();
    }

    /** Returns the builder for the settings used for calls to updateEvent. */
    public OperationCallSettings.Builder<UpdateEventRequest, Event, OperationMetadata>
        updateEventOperationSettings() {
      return getStubSettingsBuilder().updateEventOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEvent. */
    public UnaryCallSettings.Builder<DeleteEventRequest, Operation> deleteEventSettings() {
      return getStubSettingsBuilder().deleteEventSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEvent. */
    public OperationCallSettings.Builder<DeleteEventRequest, Empty, OperationMetadata>
        deleteEventOperationSettings() {
      return getStubSettingsBuilder().deleteEventOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listSeries. */
    public PagedCallSettings.Builder<ListSeriesRequest, ListSeriesResponse, ListSeriesPagedResponse>
        listSeriesSettings() {
      return getStubSettingsBuilder().listSeriesSettings();
    }

    /** Returns the builder for the settings used for calls to getSeries. */
    public UnaryCallSettings.Builder<GetSeriesRequest, Series> getSeriesSettings() {
      return getStubSettingsBuilder().getSeriesSettings();
    }

    /** Returns the builder for the settings used for calls to createSeries. */
    public UnaryCallSettings.Builder<CreateSeriesRequest, Operation> createSeriesSettings() {
      return getStubSettingsBuilder().createSeriesSettings();
    }

    /** Returns the builder for the settings used for calls to createSeries. */
    public OperationCallSettings.Builder<CreateSeriesRequest, Series, OperationMetadata>
        createSeriesOperationSettings() {
      return getStubSettingsBuilder().createSeriesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateSeries. */
    public UnaryCallSettings.Builder<UpdateSeriesRequest, Operation> updateSeriesSettings() {
      return getStubSettingsBuilder().updateSeriesSettings();
    }

    /** Returns the builder for the settings used for calls to updateSeries. */
    public OperationCallSettings.Builder<UpdateSeriesRequest, Series, OperationMetadata>
        updateSeriesOperationSettings() {
      return getStubSettingsBuilder().updateSeriesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSeries. */
    public UnaryCallSettings.Builder<DeleteSeriesRequest, Operation> deleteSeriesSettings() {
      return getStubSettingsBuilder().deleteSeriesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSeries. */
    public OperationCallSettings.Builder<DeleteSeriesRequest, Empty, OperationMetadata>
        deleteSeriesOperationSettings() {
      return getStubSettingsBuilder().deleteSeriesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to materializeChannel. */
    public UnaryCallSettings.Builder<MaterializeChannelRequest, Operation>
        materializeChannelSettings() {
      return getStubSettingsBuilder().materializeChannelSettings();
    }

    /** Returns the builder for the settings used for calls to materializeChannel. */
    public OperationCallSettings.Builder<MaterializeChannelRequest, Channel, OperationMetadata>
        materializeChannelOperationSettings() {
      return getStubSettingsBuilder().materializeChannelOperationSettings();
    }

    @Override
    public StreamsServiceSettings build() throws IOException {
      return new StreamsServiceSettings(this);
    }
  }
}
