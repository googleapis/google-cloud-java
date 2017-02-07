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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;

import com.google.pubsub.v1.TopicName;
import java.io.Serializable;
import java.util.Objects;

/**
 * Identity for a Google PubSub topic. A {@code TopicId} object can be used to create subscriptions
 * for topics that possibly reside in different projects.
 */
public final class TopicId implements Serializable {

  private static final long serialVersionUID = -4913169763174877777L;
  private static final String DELETED_TOPIC_NAME = "_deleted-topic_";
  private static final TopicId DELETED_TOPIC = new TopicId(null, DELETED_TOPIC_NAME, true);

  private final String project;
  private final String topic;
  private final boolean isDeleted;

  private TopicId(String project, String topic, boolean isDeleted) {
    this.project = project;
    this.topic = checkNotNull(topic);
    this.isDeleted = isDeleted;
  }

  private TopicId(String project, String topic) {
    this(project, topic, false);
  }

  /**
   * Returns the name of the project where the topic resides. If {@code null} the topic is assumed
   * to reside in the {@link PubSubOptions#getProjectId()} project.
   */
  @Deprecated
  public String project() {
    return getProject();
  }

  /**
   * Returns the name of the project where the topic resides. If {@code null} the topic is assumed
   * to reside in the {@link PubSubOptions#getProjectId()} project.
   */
  public String getProject() {
    return project;
  }

  /**
   * Returns the name of the topic.
   */
  @Deprecated
  public String topic() {
    return getTopic();
  }

  /**
   * Returns the name of the topic.
   */
  public String getTopic() {
    return topic;
  }

  /**
   * Returns {@code true} if this object is the identity of a deleted topic, {@code false}
   * otherwhise. If {@code isDeleted()} is {@code true}, {@link #topic()} returns
   * "{@code _deleted-topic_}" and {@link #project()} returns {@code null}.
   */
  public boolean isDeleted() {
    return isDeleted;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("project", project)
        .add("topic", topic)
        .add("isDeleted", isDeleted)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, topic, isDeleted);
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
    return Objects.equals(project, other.project)
        && Objects.equals(topic, other.topic)
        && Objects.equals(isDeleted, other.isDeleted);
  }

  String toPb(String projectId) {
    return TopicName.create(project != null ? project : projectId, topic).toString();
  }

  /**
   * Returns the identity of a deleted topic. The deleted topic is such that {@link #isDeleted()}
   * returns {@code true}, {@link #topic()} returns "{@code _is_deleted_}" and {@link #project()}
   * returns {@code null}.
   */
  public static TopicId deletedTopic() {
    return DELETED_TOPIC;
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
    if (Objects.equals(pb, DELETED_TOPIC_NAME)) {
      return DELETED_TOPIC;
    }
    TopicName topicName = TopicName.parse(pb);
    return TopicId.of(topicName.getProject(), topicName.getTopic());
  }
}
