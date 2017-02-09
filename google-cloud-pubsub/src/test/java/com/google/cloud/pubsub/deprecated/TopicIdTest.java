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

package com.google.cloud.pubsub.deprecated;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TopicIdTest {

  private static final String PROJECT = "project";
  private static final String NAME = "topic";
  private static final String TOPIC_PB = "projects/project/topics/topic";
  private static final String DELETED_TOPIC_NAME = "_deleted-topic_";

  @Test
  public void testOf() {
    TopicId topicId = TopicId.of(PROJECT, NAME);
    assertEquals(PROJECT, topicId.getProject());
    assertEquals(NAME, topicId.getTopic());
    topicId = TopicId.of(NAME);
    assertNull(topicId.getProject());
    assertEquals(NAME, topicId.getTopic());
    assertFalse(topicId.isDeleted());
  }

  @Test
  public void testOfDeprecated() {
    TopicId topicId = TopicId.of(PROJECT, NAME);
    assertEquals(PROJECT, topicId.project());
    assertEquals(NAME, topicId.topic());
    topicId = TopicId.of(NAME);
    assertNull(topicId.project());
    assertEquals(NAME, topicId.topic());
    assertFalse(topicId.isDeleted());
  }

  @Test
  public void testDeletedTopic() {
    TopicId deletedTopic = TopicId.deletedTopic();
    assertNull(deletedTopic.getProject());
    assertEquals(DELETED_TOPIC_NAME, deletedTopic.getTopic());
    assertTrue(deletedTopic.isDeleted());
    assertSame(deletedTopic, TopicId.deletedTopic());
  }

  @Test
  public void testToAndFromPb() {
    TopicId topicId = TopicId.of(PROJECT, NAME);
    String topicPb = topicId.toPb("otherProject");
    assertEquals(TOPIC_PB, topicPb);
    compareTopicId(topicId, TopicId.fromPb(topicPb));
    topicId = TopicId.of(NAME);
    topicPb = topicId.toPb("otherProject");
    assertEquals("projects/otherProject/topics/topic", topicPb);
    compareTopicId(TopicId.of("otherProject", NAME), TopicId.fromPb(topicPb));
    assertSame(TopicId.deletedTopic(), TopicId.fromPb(DELETED_TOPIC_NAME));
  }

  private void compareTopicId(TopicId expected, TopicId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), value.getProject());
    assertEquals(expected.getTopic(), value.getTopic());
    assertEquals(expected.isDeleted(), value.isDeleted());
    assertEquals(expected.toPb("project"), value.toPb("project"));
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
