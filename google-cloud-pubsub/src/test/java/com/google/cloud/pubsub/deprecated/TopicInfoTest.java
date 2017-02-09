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

import org.junit.Test;

public class TopicInfoTest {

  private static final String NAME = "topic";
  private static final TopicInfo TOPIC_INFO = TopicInfo.newBuilder("topic").build();
  private static final TopicInfo DEPRECATED_TOPIC_INFO = TopicInfo.builder("topic").build();

  @Test
  public void testToBuilder() {
    compareTopicInfo(TOPIC_INFO, TOPIC_INFO.toBuilder().build());
    TopicInfo topicInfo = TOPIC_INFO.toBuilder()
        .setName("newTopic")
        .build();
    assertEquals("newTopic", topicInfo.getName());
    topicInfo = topicInfo.toBuilder().setName(NAME).build();
    compareTopicInfo(TOPIC_INFO, topicInfo);
  }

  @Test
  public void testBuilder() {
    assertEquals(NAME, TOPIC_INFO.getName());
    TopicInfo topicInfo = TopicInfo.newBuilder("wrongName").setName(NAME).build();
    compareTopicInfo(TOPIC_INFO, topicInfo);
  }

  @Test
  public void testBuilderDeprecated() {
    assertEquals(NAME, DEPRECATED_TOPIC_INFO.name());
    TopicInfo topicInfo = TopicInfo.builder("wrongName").name(NAME).build();
    compareTopicInfo(TOPIC_INFO, topicInfo);
  }

  @Test
  public void testOf() {
    compareTopicInfo(TOPIC_INFO, TopicInfo.of(NAME));
  }

  @Test
  public void testToAndFromPb() {
    compareTopicInfo(TOPIC_INFO, TopicInfo.fromPb(TOPIC_INFO.toPb("project")));
    assertEquals("projects/project/topics/topic", TOPIC_INFO.toPb("project").getName());
  }

  private void compareTopicInfo(TopicInfo expected, TopicInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
