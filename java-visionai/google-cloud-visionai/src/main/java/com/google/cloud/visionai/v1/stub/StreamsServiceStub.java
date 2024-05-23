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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the StreamsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class StreamsServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListClustersRequest, ListClustersPagedResponse> listClustersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listClustersPagedCallable()");
  }

  public UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listClustersCallable()");
  }

  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getClusterCallable()");
  }

  public OperationCallable<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createClusterOperationCallable()");
  }

  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createClusterCallable()");
  }

  public OperationCallable<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateClusterOperationCallable()");
  }

  public UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateClusterCallable()");
  }

  public OperationCallable<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteClusterOperationCallable()");
  }

  public UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteClusterCallable()");
  }

  public UnaryCallable<ListStreamsRequest, ListStreamsPagedResponse> listStreamsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listStreamsPagedCallable()");
  }

  public UnaryCallable<ListStreamsRequest, ListStreamsResponse> listStreamsCallable() {
    throw new UnsupportedOperationException("Not implemented: listStreamsCallable()");
  }

  public UnaryCallable<GetStreamRequest, Stream> getStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: getStreamCallable()");
  }

  public OperationCallable<CreateStreamRequest, Stream, OperationMetadata>
      createStreamOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createStreamOperationCallable()");
  }

  public UnaryCallable<CreateStreamRequest, Operation> createStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: createStreamCallable()");
  }

  public OperationCallable<UpdateStreamRequest, Stream, OperationMetadata>
      updateStreamOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateStreamOperationCallable()");
  }

  public UnaryCallable<UpdateStreamRequest, Operation> updateStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: updateStreamCallable()");
  }

  public OperationCallable<DeleteStreamRequest, Empty, OperationMetadata>
      deleteStreamOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteStreamOperationCallable()");
  }

  public UnaryCallable<DeleteStreamRequest, Operation> deleteStreamCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteStreamCallable()");
  }

  public OperationCallable<GetStreamThumbnailRequest, GetStreamThumbnailResponse, OperationMetadata>
      getStreamThumbnailOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getStreamThumbnailOperationCallable()");
  }

  public UnaryCallable<GetStreamThumbnailRequest, Operation> getStreamThumbnailCallable() {
    throw new UnsupportedOperationException("Not implemented: getStreamThumbnailCallable()");
  }

  public UnaryCallable<GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>
      generateStreamHlsTokenCallable() {
    throw new UnsupportedOperationException("Not implemented: generateStreamHlsTokenCallable()");
  }

  public UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEventsPagedCallable()");
  }

  public UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEventsCallable()");
  }

  public UnaryCallable<GetEventRequest, Event> getEventCallable() {
    throw new UnsupportedOperationException("Not implemented: getEventCallable()");
  }

  public OperationCallable<CreateEventRequest, Event, OperationMetadata>
      createEventOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createEventOperationCallable()");
  }

  public UnaryCallable<CreateEventRequest, Operation> createEventCallable() {
    throw new UnsupportedOperationException("Not implemented: createEventCallable()");
  }

  public OperationCallable<UpdateEventRequest, Event, OperationMetadata>
      updateEventOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEventOperationCallable()");
  }

  public UnaryCallable<UpdateEventRequest, Operation> updateEventCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEventCallable()");
  }

  public OperationCallable<DeleteEventRequest, Empty, OperationMetadata>
      deleteEventOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEventOperationCallable()");
  }

  public UnaryCallable<DeleteEventRequest, Operation> deleteEventCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEventCallable()");
  }

  public UnaryCallable<ListSeriesRequest, ListSeriesPagedResponse> listSeriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSeriesPagedCallable()");
  }

  public UnaryCallable<ListSeriesRequest, ListSeriesResponse> listSeriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSeriesCallable()");
  }

  public UnaryCallable<GetSeriesRequest, Series> getSeriesCallable() {
    throw new UnsupportedOperationException("Not implemented: getSeriesCallable()");
  }

  public OperationCallable<CreateSeriesRequest, Series, OperationMetadata>
      createSeriesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createSeriesOperationCallable()");
  }

  public UnaryCallable<CreateSeriesRequest, Operation> createSeriesCallable() {
    throw new UnsupportedOperationException("Not implemented: createSeriesCallable()");
  }

  public OperationCallable<UpdateSeriesRequest, Series, OperationMetadata>
      updateSeriesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSeriesOperationCallable()");
  }

  public UnaryCallable<UpdateSeriesRequest, Operation> updateSeriesCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSeriesCallable()");
  }

  public OperationCallable<DeleteSeriesRequest, Empty, OperationMetadata>
      deleteSeriesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSeriesOperationCallable()");
  }

  public UnaryCallable<DeleteSeriesRequest, Operation> deleteSeriesCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSeriesCallable()");
  }

  public OperationCallable<MaterializeChannelRequest, Channel, OperationMetadata>
      materializeChannelOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: materializeChannelOperationCallable()");
  }

  public UnaryCallable<MaterializeChannelRequest, Operation> materializeChannelCallable() {
    throw new UnsupportedOperationException("Not implemented: materializeChannelCallable()");
  }

  @Override
  public abstract void close();
}
