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

package com.google.gcloud.pubsub;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Pub/Sub Topic information.
 */
public class TopicInfo implements Serializable {

  private static final long serialVersionUID = -5907624842808725353L;

  private final String name;

  /**
   * Builder for TopicInfo.
   */
  public abstract static class Builder {

    public abstract Builder name(String name);

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
    public Builder name(String name) {
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

  public String name() {
    return name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    return Objects.equals(toPb(), ((TopicInfo) obj).toPb());
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .toString();
  }

  com.google.pubsub.v1.Topic toPb() {
    return com.google.pubsub.v1.Topic.newBuilder().setName(name).build();
  }

  static TopicInfo fromPb(com.google.pubsub.v1.Topic topicPb) {
    return builder(topicPb.getName()).build();
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static TopicInfo of(String name) {
    return builder(name).build();
  }

  public static Builder builder(String name) {
    return new BuilderImpl(name);
  }
}
