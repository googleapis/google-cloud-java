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
  private static final VersionFormat VERSION = VersionFormat.V2;
  private static final BucketDestination BUCKET_DESTINATION = BucketDestination.of("bucket");
  private static final DatasetDestination DATASET_DESTINATION =
      DatasetDestination.of("project", "dataset");
  private static final TopicDestination TOPIC_DESTINATION = TopicDestination.of("project", "topic");
  private static final SinkInfo BUCKET_SINK_INFO =
      SinkInfo.newBuilder(NAME, BUCKET_DESTINATION)
          .setFilter(FILTER)
          .setVersionFormat(VERSION)
          .build();
  private static final SinkInfo DATASET_SINK_INFO =
      SinkInfo.newBuilder(NAME, DATASET_DESTINATION)
          .setFilter(FILTER)
          .setVersionFormat(VERSION)
          .build();
  private static final SinkInfo TOPIC_SINK_INFO =
      SinkInfo.newBuilder(NAME, TOPIC_DESTINATION)
          .setFilter(FILTER)
          .setVersionFormat(VERSION)
          .build();

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testOfBucketDestination() {
    assertEquals(Destination.Type.BUCKET, BUCKET_DESTINATION.getType());
    assertEquals("bucket", BUCKET_DESTINATION.getBucket());
  }

  @Test
  public void testOfDatasetDestination() {
    assertEquals(Destination.Type.DATASET, DATASET_DESTINATION.getType());
    assertEquals("project", DATASET_DESTINATION.getProject());
    assertEquals("dataset", DATASET_DESTINATION.getDataset());
    DatasetDestination datasetDestination = DatasetDestination.of("dataset");
    assertNull(datasetDestination.getProject());
    assertEquals("dataset", datasetDestination.getDataset());
  }

  @Test
  public void testOfTopicDestination() {
    assertEquals(Destination.Type.TOPIC, TOPIC_DESTINATION.getType());
    assertEquals("project", TOPIC_DESTINATION.getProject());
    assertEquals("topic", TOPIC_DESTINATION.getTopic());
    TopicDestination topicDestination = TopicDestination.of("topic");
    assertNull(topicDestination.getProject());
    assertEquals("topic", topicDestination.getTopic());
  }

  @Test
  public void testToAndFromPbDestination() {
    BucketDestination bucketDestination = Destination.fromPb(BUCKET_DESTINATION.toPb("other"));
    assertEquals(Destination.Type.BUCKET, bucketDestination.getType());
    assertEquals("bucket", bucketDestination.getBucket());
    compareBucketDestination(BUCKET_DESTINATION, bucketDestination);
    DatasetDestination datasetDestination = Destination.fromPb(DATASET_DESTINATION.toPb("other"));
    assertEquals(Destination.Type.DATASET, datasetDestination.getType());
    assertEquals("project", datasetDestination.getProject());
    assertEquals("dataset", datasetDestination.getDataset());
    compareDatasetDestination(DATASET_DESTINATION, datasetDestination);
    TopicDestination topicDestination = Destination.fromPb(TOPIC_DESTINATION.toPb("other"));
    assertEquals(Destination.Type.TOPIC, topicDestination.getType());
    assertEquals("project", topicDestination.getProject());
    assertEquals("topic", topicDestination.getTopic());
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
    assertEquals("project", datasetDestination.getProject());
    TopicDestination topicDestination =
        TopicDestination.fromPb(TopicDestination.of("topic").toPb("project"));
    assertEquals("project", topicDestination.getProject());
    compareTopicDestination(TOPIC_DESTINATION, topicDestination);
  }

  @Test
  public void testBuilder() {
    assertEquals(NAME, BUCKET_SINK_INFO.getName());
    assertEquals(BUCKET_DESTINATION, BUCKET_SINK_INFO.getDestination());
    assertEquals(FILTER, BUCKET_SINK_INFO.getFilter());
    assertEquals(VERSION, BUCKET_SINK_INFO.getVersionFormat());
    assertEquals(NAME, DATASET_SINK_INFO.getName());
    assertEquals(DATASET_DESTINATION, DATASET_SINK_INFO.getDestination());
    assertEquals(FILTER, DATASET_SINK_INFO.getFilter());
    assertEquals(VERSION, DATASET_SINK_INFO.getVersionFormat());
    assertEquals(NAME, TOPIC_SINK_INFO.getName());
    assertEquals(TOPIC_DESTINATION, TOPIC_SINK_INFO.getDestination());
    assertEquals(FILTER, TOPIC_SINK_INFO.getFilter());
    assertEquals(VERSION, TOPIC_SINK_INFO.getVersionFormat());
  }

  @Test
  public void testToBuilder() {
    compareSinkInfo(BUCKET_SINK_INFO, BUCKET_SINK_INFO.toBuilder().build());
    compareSinkInfo(DATASET_SINK_INFO, DATASET_SINK_INFO.toBuilder().build());
    compareSinkInfo(TOPIC_SINK_INFO, TOPIC_SINK_INFO.toBuilder().build());
    SinkInfo updatedSinkInfo =
        BUCKET_SINK_INFO
            .toBuilder()
            .setDestination(TOPIC_DESTINATION)
            .setName("newName")
            .setFilter("logName=projects/my-projectid/logs/syslog")
            .setVersionFormat(VersionFormat.V2)
            .build();
    assertEquals("newName", updatedSinkInfo.getName());
    assertEquals(TOPIC_DESTINATION, updatedSinkInfo.getDestination());
    assertEquals("logName=projects/my-projectid/logs/syslog", updatedSinkInfo.getFilter());
    assertEquals(VersionFormat.V2, updatedSinkInfo.getVersionFormat());
    updatedSinkInfo =
        BUCKET_SINK_INFO
            .toBuilder()
            .setDestination(BUCKET_DESTINATION)
            .setName(NAME)
            .setFilter(FILTER)
            .setVersionFormat(VersionFormat.V2)
            .build();
    assertEquals(BUCKET_SINK_INFO, updatedSinkInfo);
  }

  @Test
  public void testToAndFromPb() {
    compareSinkInfo(BUCKET_SINK_INFO, SinkInfo.fromPb(BUCKET_SINK_INFO.toPb("project")));
    compareSinkInfo(DATASET_SINK_INFO, SinkInfo.fromPb(DATASET_SINK_INFO.toPb("project")));
    compareSinkInfo(TOPIC_SINK_INFO, SinkInfo.fromPb(TOPIC_SINK_INFO.toPb("project")));
    SinkInfo sinkInfo =
        SinkInfo.newBuilder(NAME, BUCKET_DESTINATION).setVersionFormat(VERSION).build();
    compareSinkInfo(sinkInfo, SinkInfo.fromPb(sinkInfo.toPb("project")));
    sinkInfo = SinkInfo.newBuilder(NAME, DATASET_DESTINATION).setVersionFormat(VERSION).build();
    compareSinkInfo(sinkInfo, SinkInfo.fromPb(sinkInfo.toPb("project")));
    sinkInfo = SinkInfo.newBuilder(NAME, TOPIC_DESTINATION).setVersionFormat(VERSION).build();
    compareSinkInfo(sinkInfo, SinkInfo.fromPb(sinkInfo.toPb("project")));
  }

  @Test
  public void testToAndFromPb_NoProjectId() {
    DatasetDestination datasetDestination = DatasetDestination.of("dataset");
    SinkInfo sinkInfo =
        SinkInfo.newBuilder(NAME, DATASET_DESTINATION).setVersionFormat(VERSION).build();
    compareSinkInfo(
        sinkInfo, SinkInfo.fromPb(SinkInfo.of("name", datasetDestination).toPb("project")));
    TopicDestination topicDestination = TopicDestination.of("topic");
    sinkInfo = SinkInfo.newBuilder(NAME, TOPIC_DESTINATION).setVersionFormat(VERSION).build();
    compareSinkInfo(
        sinkInfo, SinkInfo.fromPb(SinkInfo.of("name", topicDestination).toPb("project")));
  }

  private void compareBucketDestination(BucketDestination expected, BucketDestination value) {
    assertEquals(expected, value);
    assertEquals(expected.getBucket(), value.getBucket());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }

  private void compareDatasetDestination(DatasetDestination expected, DatasetDestination value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), value.getProject());
    assertEquals(expected.getDataset(), value.getDataset());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }

  private void compareTopicDestination(TopicDestination expected, TopicDestination value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), value.getProject());
    assertEquals(expected.getTopic(), value.getTopic());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }

  private void compareSinkInfo(SinkInfo expected, SinkInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getDestination(), value.getDestination());
    assertEquals(expected.getFilter(), value.getFilter());
    assertEquals(expected.getVersionFormat(), value.getVersionFormat());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
