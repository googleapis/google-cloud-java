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

package com.google.cloud.pubsub;

import static com.google.cloud.pubsub.spi.v1.PublisherApi.formatTopicName;
import static com.google.cloud.pubsub.spi.v1.PublisherApi.parseProjectFromTopicName;
import static com.google.cloud.pubsub.spi.v1.PublisherApi.parseTopicFromTopicName;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Identity for a Google PubSub topic. A {@code TopicId} object can be used to create subscriptions
 * for topics that possibly reside in different projects.
 */
public final class TopicId implements Serializable {

  private static final long serialVersionUID = -4913169763174877777L;

  private final String project;
  private final String topic;

  private TopicId(String project, String topic) {
    this.project = project;
    this.topic = checkNotNull(topic);
  }

  /**
   * Returns the name of the project where the topic resides. If {@code null} the topic is assumed
   * to reside in the {@link PubSubOptions#projectId()} project.
   */
  public String project() {
    return project;
  }

  /**
   * Returns the name of the topic.
   */
  public String topic() {
    return topic;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("project", project).add("topic", topic).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, topic);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof TopicId)) {
      return false;
    }
    TopicId other = (TopicId) obj;
    return Objects.equals(project, other.project) && Objects.equals(topic, other.topic);
  }

  String toPb(String projectId) {
    return formatTopicName(project != null ? project : projectId, topic);
  }

  /**
   * Returns a topic identity given the topic name.
   */
  public static TopicId of(String topic) {
    return new TopicId(null, topic);
  }

  /**
   * Returns a topic identity given project and topic names.
   */
  public static TopicId of(String project, String topic) {
    return new TopicId(project, topic);
  }

  static TopicId fromPb(String pb) {
    return TopicId.of(parseProjectFromTopicName(pb), parseTopicFromTopicName(pb));
  }
}
