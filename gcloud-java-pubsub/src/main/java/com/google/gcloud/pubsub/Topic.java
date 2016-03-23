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

import com.google.gcloud.AsyncPage;
import com.google.gcloud.Page;
import com.google.gcloud.pubsub.PubSub.ListOption;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;

/**
 * PubSub Topic.
 */
public class Topic extends TopicInfo {

  private final PubSubOptions options;
  private transient PubSub pubsub;

  public static final class Builder extends TopicInfo.Builder {

    private final PubSub pubsub;
    private final BuilderImpl delegate;

    private Builder(Topic topic) {
      pubsub = topic.pubsub;
      delegate = new BuilderImpl(topic);
    }

    @Override
    public Builder name(String name) {
      delegate.name(name);
      return this;
    }

    @Override
    public Topic build() {
      return new Topic(this.pubsub, this.delegate);
    }
  }

  Topic(PubSub pubsub, BuilderImpl builder) {
    super(builder);
    this.pubsub = checkNotNull(pubsub);
    options = pubsub.options();
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(options, super.hashCode());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Topic other = (Topic) obj;
    return Objects.equals(toPb(), other.toPb()) && Objects.equals(options, other.options);
  }

  public PubSub pubSub() {
    return pubsub;
  }

  public boolean delete() {
    return pubsub.deleteTopic(name());
  }

  public Future<Boolean> deleteAsync() {
    return pubsub.deleteTopicAsync(name());
  }

  public Topic reload() {
    return pubsub.getTopic(name());
  }

  public Future<Topic> reloadAsync() {
    return pubsub.getTopicAsync(name());
  }

  public String publish(Message message) {
    return pubsub.publish(name(), message);
  }

  public Future<String> publishAsync(Message message) {
    return pubsub.publishAsync(name(), message);
  }

  public List<String> publish(Message message, Message... messages) {
    return pubsub.publish(name(), message, messages);
  }

  public Future<List<String>> publishAsync(Message message, Message... messages) {
    return pubsub.publishAsync(name(), message, messages);
  }

  public List<String> publish(Iterable<Message> messages) {
    return pubsub.publish(name(), messages);
  }

  public Future<List<String>> publishAsync(Iterable<Message> messages) {
    return pubsub.publishAsync(name(), messages);
  }

  public Page<Subscription> listSubscriptions(ListOption... options) {
    return pubsub.listSubscriptions(name(), options);
  }

  public Future<AsyncPage<Subscription>> listSubscriptionsAsync(ListOption... options) {
    return pubsub.listSubscriptionsAsync(name(), options);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.pubsub = options.service();
  }

  static Topic fromPb(PubSub storage, com.google.pubsub.v1.Topic topicPb) {
    TopicInfo topicInfo = TopicInfo.fromPb(topicPb);
    return new Topic(storage, new BuilderImpl(topicInfo));
  }
}
