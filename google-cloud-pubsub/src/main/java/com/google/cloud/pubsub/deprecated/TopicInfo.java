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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.pubsub.v1.TopicName;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Google Cloud Pub/Sub topic. A topic is a named resource to which messages are sent by
 * publishers. Subscribers can receive messages sent to a topic by creating subscriptions.
 *
 * @see <a href="https://cloud.google.com/pubsub/overview#data_model">Pub/Sub Data Model</a>
 */
public class TopicInfo implements Serializable {

  private static final long serialVersionUID = -5907624842808725353L;

  private final String name;

  /**
   * Builder for {@code TopicInfo} objects.
   */
  public abstract static class Builder {

    /**
     * Sets the name of the topic. The name must start with a letter, and contain only letters
     * ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores ({@code _}),
     * periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs ({@code %}). It
     * must be between 3 and 255 characters in length and cannot begin with the string {@code goog}.
     */
    @Deprecated
    public abstract Builder name(String name);

    /**
     * Sets the name of the topic. The name must start with a letter, and contain only letters
     * ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores ({@code _}),
     * periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs ({@code %}). It
     * must be between 3 and 255 characters in length and cannot begin with the string {@code goog}.
     */
    public abstract Builder setName(String name);

    /**
     * Creates a topic object.
     */
    public abstract TopicInfo build();
  }

  static final class BuilderImpl extends Builder {

    private String name;

    BuilderImpl(String name) {
      this.name = checkNotNull(name);
    }

    BuilderImpl(TopicInfo topicInfo) {
      this.name = topicInfo.name;
    }

    @Override
    @Deprecated
    public Builder name(String name) {
      return setName(name);
    }

    @Override
    public Builder setName(String name) {
      this.name = checkNotNull(name);
      return this;
    }

    @Override
    public TopicInfo build() {
      return new TopicInfo(this);
    }
  }

  TopicInfo(BuilderImpl builder) {
    name = builder.name;
  }

  /**
   * Returns the name of the topic. The name must start with a letter, and contain only letters
   * ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores ({@code _}),
   * periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs ({@code %}). It
   * must be between 3 and 255 characters in length and cannot begin with the string {@code goog}.
   */
  @Deprecated
  public String name() {
    return getName();
  }

  /**
   * Returns the name of the topic. The name must start with a letter, and contain only letters
   * ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores ({@code _}),
   * periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs ({@code %}). It
   * must be between 3 and 255 characters in length and cannot begin with the string {@code goog}.
   */
  public String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  final boolean baseEquals(TopicInfo topicInfo) {
    return Objects.equals(name, topicInfo.name);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
        && obj.getClass().equals(TopicInfo.class)
        && baseEquals((TopicInfo) obj);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .toString();
  }

  com.google.pubsub.v1.Topic toPb(String projectId) {
    return com.google.pubsub.v1.Topic.newBuilder()
        .setNameWithTopicName(TopicName.create(projectId, name))
        .build();
  }

  static TopicInfo fromPb(com.google.pubsub.v1.Topic topicPb) {
    return newBuilder(topicPb.getNameAsTopicName().getTopic()).build();
  }

  /**
   * Returns a builder for the topic object.
   */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  /**
   * Creates a {@code TopicInfo} object given the name of the topic.
   *
   * @param name the name of the topic. The name must start with a letter, and contain only letters
   *     ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores ({@code _}),
   *     periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs ({@code %}).
   *     It must be between 3 and 255 characters in length and cannot begin with the string
   *     {@code goog}.
   */
  public static TopicInfo of(String name) {
    return newBuilder(name).build();
  }

  /**
   * Creates a builder for {@code TopicInfo} objects given the name of the topic.
   *
   * @param name the name of the topic. The name must start with a letter, and contain only letters
   *     ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores ({@code _}),
   *     periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs ({@code %}).
   *     It must be between 3 and 255 characters in length and cannot begin with the string
   *     {@code goog}.
   */
  @Deprecated
  public static Builder builder(String name) {
    return newBuilder(name);
  }

  /**
   * Creates a builder for {@code TopicInfo} objects given the name of the topic.
   *
   * @param name the name of the topic. The name must start with a letter, and contain only letters
   *     ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores ({@code _}),
   *     periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs ({@code %}).
   *     It must be between 3 and 255 characters in length and cannot begin with the string
   *     {@code goog}.
   */
  public static Builder newBuilder(String name) {
    return new BuilderImpl(name);
  }
}
