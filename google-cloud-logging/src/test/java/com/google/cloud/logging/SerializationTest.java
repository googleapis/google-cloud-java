/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging;

import com.google.cloud.BaseSerializationTest;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.MonitoredResource;
import com.google.cloud.NoCredentials;
import com.google.cloud.Restorable;
import com.google.cloud.logging.Logging.EntryListOption;
import com.google.cloud.logging.Logging.ListOption;
import com.google.cloud.logging.Logging.SortingField;
import com.google.cloud.logging.Logging.SortingOrder;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.Payload.JsonPayload;
import com.google.cloud.logging.Payload.ProtoPayload;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.cloud.logging.SinkInfo.Destination.BucketDestination;
import com.google.cloud.logging.SinkInfo.Destination.DatasetDestination;
import com.google.cloud.logging.SinkInfo.Destination.TopicDestination;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;

import java.io.Serializable;

public class SerializationTest extends BaseSerializationTest {

  private static final Logging LOGGING = LoggingOptions.newBuilder()
      .setProjectId("p")
      .setCredentials(NoCredentials.getInstance())
      .setHost("localhost")
      .build().getService();
  private static final HttpRequest HTTP_REQUEST = HttpRequest.newBuilder()
      .setRequestMethod(HttpRequest.RequestMethod.GET)
      .setStatus(404)
      .build();
  private static final Operation OPERATION = Operation.of("id", "producer");
  private static final StringPayload STRING_PAYLOAD = StringPayload.of("payload");
  private static final JsonPayload JSON_PAYLOAD =
      JsonPayload.of(ImmutableMap.<String, Object>of("key", "val"));
  private static final ProtoPayload PROTO_PAYLOAD =
      ProtoPayload.of(Any.pack(Empty.getDefaultInstance()));
  private static final LogEntry ENTRY = LogEntry.of(STRING_PAYLOAD);
  private static final MetricInfo METRIC_INFO =
      MetricInfo.of("metric", "logName=projects/my-projectid/logs/syslog");
  private static final Metric METRIC = new Metric(LOGGING, new Metric.BuilderImpl(METRIC_INFO));
  private static final BucketDestination BUCKET_DESTINATION = BucketDestination.of("bucket");
  private static final DatasetDestination DATASET_DESTINATION =
      DatasetDestination.of("project", "dataset");
  private static final TopicDestination TOPIC_DESTINATION = TopicDestination.of("project", "topic");
  private static final SinkInfo SINK_INFO = SinkInfo.of("sink", BUCKET_DESTINATION);
  private static final Sink SINK = new Sink(LOGGING, new Sink.BuilderImpl(SINK_INFO));
  private static final ListOption PAGE_TOKEN_OPTION = ListOption.pageToken("token");
  private static final ListOption PAGE_SIZE_OPTION = ListOption.pageSize(42);
  private static final WriteOption LABELS_OPTION =
      WriteOption.labels(ImmutableMap.of("key", "val"));
  private static final WriteOption LOG_OPTION =
      WriteOption.labels(ImmutableMap.of("key", "val"));
  private static final WriteOption RESOURCE_OPTION =
      WriteOption.resource(MonitoredResource.of("global", ImmutableMap.of("project_id", "p")));
  private static final EntryListOption ENTRY_PAGE_TOKEN_OPTION = EntryListOption.pageToken("token");
  private static final EntryListOption ENTRY_PAGE_SIZE_OPTION = EntryListOption.pageSize(42);
  private static final EntryListOption ENTRY_FILTER_OPTION = EntryListOption.filter("filter");
  private static final EntryListOption ENTRY_SORT_ORDER_OPTION =
      EntryListOption.sortOrder(SortingField.TIMESTAMP, SortingOrder.ASCENDING);

  @Override
  protected Serializable[] serializableObjects() {
    GrpcTransportOptions transportOptions = LoggingOptions.getDefaultGrpcTransportOptions();
    LoggingOptions options = LoggingOptions.newBuilder()
        .setProjectId("p1")
        .setTransportOptions(transportOptions)
        .build();
    return new Serializable[]{options, HTTP_REQUEST, OPERATION, STRING_PAYLOAD, JSON_PAYLOAD,
        PROTO_PAYLOAD, ENTRY, METRIC_INFO, METRIC, BUCKET_DESTINATION, DATASET_DESTINATION,
        TOPIC_DESTINATION, SINK_INFO, SINK, PAGE_TOKEN_OPTION, PAGE_SIZE_OPTION, LABELS_OPTION,
        LOG_OPTION, RESOURCE_OPTION, ENTRY_PAGE_TOKEN_OPTION, ENTRY_PAGE_SIZE_OPTION,
        ENTRY_FILTER_OPTION, ENTRY_SORT_ORDER_OPTION};
  }

  @Override
  protected Restorable<?>[] restorableObjects() {
    return null;
  }
}
