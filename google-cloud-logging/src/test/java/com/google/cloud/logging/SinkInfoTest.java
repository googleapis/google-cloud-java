/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.cloud.logging.SinkInfo.Destination;
import com.google.cloud.logging.SinkInfo.Destination.BucketDestination;
import com.google.cloud.logging.SinkInfo.Destination.DatasetDestination;
import com.google.cloud.logging.SinkInfo.Destination.TopicDestination;
import com.google.cloud.logging.SinkInfo.VersionFormat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SinkInfoTest {

  private static final String NAME = "name";
  private static final String FILTER =
      "logName=projects/my-projectid/logs/syslog AND severity>=ERROR";
  private static final VersionFormat VERSION = VersionFormat.V1;
  private static final BucketDestination BUCKET_DESTINATION = BucketDestination.of("bucket");
  private static final DatasetDestination DATASET_DESTINATION =
      DatasetDestination.of("project", "dataset");
  private static final TopicDestination TOPIC_DESTINATION =
      TopicDestination.of("project", "topic");
  private static final SinkInfo BUCKET_SINK_INFO = SinkInfo.builder(NAME, BUCKET_DESTINATION)
      .filter(FILTER)
      .versionFormat(VERSION)
      .build();
  private static final SinkInfo DATASET_SINK_INFO = SinkInfo.builder(NAME, DATASET_DESTINATION)
      .filter(FILTER)
      .versionFormat(VERSION)
      .build();
  private static final SinkInfo TOPIC_SINK_INFO = SinkInfo.builder(NAME, TOPIC_DESTINATION)
      .filter(FILTER)
      .versionFormat(VERSION)
      .build();

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testOfBucketDestination() {
    assertEquals(Destination.Type.BUCKET, BUCKET_DESTINATION.type());
    assertEquals("bucket", BUCKET_DESTINATION.bucket());
  }

  @Test
  public void testOfDatasetDestination() {
    assertEquals(Destination.Type.DATASET, DATASET_DESTINATION.type());
    assertEquals("project", DATASET_DESTINATION.project());
    assertEquals("dataset", DATASET_DESTINATION.dataset());
    DatasetDestination datasetDestination = DatasetDestination.of("dataset");
    assertNull(datasetDestination.project());
    assertEquals("dataset", datasetDestination.dataset());
  }

  @Test
  public void testOfTopicDestination() {
    assertEquals(Destination.Type.TOPIC, TOPIC_DESTINATION.type());
    assertEquals("project", TOPIC_DESTINATION.project());
    assertEquals("topic", TOPIC_DESTINATION.topic());
    TopicDestination topicDestination = TopicDestination.of("topic");
    assertNull(topicDestination.project());
    assertEquals("topic", topicDestination.topic());
  }

  @Test
  public void testToAndFromPbDestination() {
    BucketDestination bucketDestination = Destination.fromPb(BUCKET_DESTINATION.toPb("other"));
    assertEquals(Destination.Type.BUCKET, bucketDestination.type());
    assertEquals("bucket", bucketDestination.bucket());
    compareBucketDestination(BUCKET_DESTINATION, bucketDestination);
    DatasetDestination datasetDestination = Destination.fromPb(DATASET_DESTINATION.toPb("other"));
    assertEquals(Destination.Type.DATASET, datasetDestination.type());
    assertEquals("project", datasetDestination.project());
    assertEquals("dataset", datasetDestination.dataset());
    compareDatasetDestination(DATASET_DESTINATION, datasetDestination);
    TopicDestination topicDestination = Destination.fromPb(TOPIC_DESTINATION.toPb("other"));
    assertEquals(Destination.Type.TOPIC, topicDestination.type());
    assertEquals("project", topicDestination.project());
    assertEquals("topic", topicDestination.topic());
    compareTopicDestination(TOPIC_DESTINATION, topicDestination);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("wrongDestination is not a valid sink destination");
    Destination.fromPb("wrongDestination");
  }

  @Test
  public void testToAndFromPbDestination_NoProjectId() {
    DatasetDestination datasetDestination =
        DatasetDestination.fromPb(DatasetDestination.of("dataset").toPb("project"));
    compareDatasetDestination(DATASET_DESTINATION, datasetDestination);
    assertEquals("project", datasetDestination.project());
    TopicDestination topicDestination =
        TopicDestination.fromPb(TopicDestination.of("topic").toPb("project"));
    assertEquals("project", topicDestination.project());
    compareTopicDestination(TOPIC_DESTINATION, topicDestination);
  }

  @Test
  public void testBuilder() {
    assertEquals(NAME, BUCKET_SINK_INFO.name());
    assertEquals(BUCKET_DESTINATION, BUCKET_SINK_INFO.destination());
    assertEquals(FILTER, BUCKET_SINK_INFO.filter());
    assertEquals(VERSION, BUCKET_SINK_INFO.versionFormat());
    assertEquals(NAME, DATASET_SINK_INFO.name());
    assertEquals(DATASET_DESTINATION, DATASET_SINK_INFO.destination());
    assertEquals(FILTER, DATASET_SINK_INFO.filter());
    assertEquals(VERSION, DATASET_SINK_INFO.versionFormat());
    assertEquals(NAME, TOPIC_SINK_INFO.name());
    assertEquals(TOPIC_DESTINATION, TOPIC_SINK_INFO.destination());
    assertEquals(FILTER, TOPIC_SINK_INFO.filter());
    assertEquals(VERSION, TOPIC_SINK_INFO.versionFormat());
  }

  @Test
  public void testToBuilder() {
    compareSinkInfo(BUCKET_SINK_INFO, BUCKET_SINK_INFO.toBuilder().build());
    compareSinkInfo(DATASET_SINK_INFO, DATASET_SINK_INFO.toBuilder().build());
    compareSinkInfo(TOPIC_SINK_INFO, TOPIC_SINK_INFO.toBuilder().build());
    SinkInfo updatedSinkInfo = BUCKET_SINK_INFO.toBuilder()
        .destination(TOPIC_DESTINATION)
        .name("newName")
        .filter("logName=projects/my-projectid/logs/syslog")
        .versionFormat(VersionFormat.V2)
        .build();
    assertEquals("newName", updatedSinkInfo.name());
    assertEquals(TOPIC_DESTINATION, updatedSinkInfo.destination());
    assertEquals("logName=projects/my-projectid/logs/syslog", updatedSinkInfo.filter());
    assertEquals(VersionFormat.V2, updatedSinkInfo.versionFormat());
    updatedSinkInfo = BUCKET_SINK_INFO.toBuilder()
        .destination(BUCKET_DESTINATION)
        .name(NAME)
        .filter(FILTER)
        .versionFormat(VersionFormat.V1)
        .build();
    assertEquals(BUCKET_SINK_INFO, updatedSinkInfo);
  }

  @Test
  public void testToAndFromPb() {
    compareSinkInfo(BUCKET_SINK_INFO, SinkInfo.fromPb(BUCKET_SINK_INFO.toPb("project")));
    compareSinkInfo(DATASET_SINK_INFO, SinkInfo.fromPb(DATASET_SINK_INFO.toPb("project")));
    compareSinkInfo(TOPIC_SINK_INFO, SinkInfo.fromPb(TOPIC_SINK_INFO.toPb("project")));
    SinkInfo sinkInfo = SinkInfo.of("name", BUCKET_DESTINATION);
    compareSinkInfo(sinkInfo, SinkInfo. fromPb(sinkInfo.toPb("project")));
    sinkInfo = SinkInfo.of("name", DATASET_DESTINATION);
    compareSinkInfo(sinkInfo, SinkInfo.fromPb(sinkInfo.toPb("project")));
    sinkInfo = SinkInfo.of("name", TOPIC_DESTINATION);
    compareSinkInfo(sinkInfo, SinkInfo.fromPb(sinkInfo.toPb("project")));
  }

  @Test
  public void testToAndFromPb_NoProjectId() {
    DatasetDestination datasetDestination = DatasetDestination.of("dataset");
    SinkInfo sinkInfo = SinkInfo.of("name", DATASET_DESTINATION);
    compareSinkInfo(sinkInfo,
        SinkInfo.fromPb(SinkInfo.of("name", datasetDestination).toPb("project")));
    TopicDestination topicDestination = TopicDestination.of("topic");
    sinkInfo = SinkInfo.of("name", TOPIC_DESTINATION);
    compareSinkInfo(sinkInfo,
        SinkInfo.fromPb(SinkInfo.of("name", topicDestination).toPb("project")));
  }

  private void compareBucketDestination(BucketDestination expected, BucketDestination value) {
    assertEquals(expected, value);
    assertEquals(expected.bucket(), value.bucket());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }

  private void compareDatasetDestination(DatasetDestination expected, DatasetDestination value) {
    assertEquals(expected, value);
    assertEquals(expected.project(), value.project());
    assertEquals(expected.dataset(), value.dataset());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }

  private void compareTopicDestination(TopicDestination expected, TopicDestination value) {
    assertEquals(expected, value);
    assertEquals(expected.project(), value.project());
    assertEquals(expected.topic(), value.topic());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }

  private void compareSinkInfo(SinkInfo expected, SinkInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.name(), value.name());
    assertEquals(expected.destination(), value.destination());
    assertEquals(expected.filter(), value.filter());
    assertEquals(expected.versionFormat(), value.versionFormat());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
