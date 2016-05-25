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

/**
 * Interface for an automatic ack deadline renewer. An ack deadline renewer automatically renews
 * the acknowledge deadline of messages added to it (via {@link #add(String, String)} or
 * {@link #add(String, Iterable)}. The acknowledge deadlines of added messages are renewed until
 * the messages are explicitly removed using either {@link #remove(String, String)} or
 * {@link #remove(String, Iterable)}.
 */
interface AckDeadlineRenewer extends AutoCloseable {

  /**
   * Adds a new message for which the acknowledge deadline should be automatically renewed. The
   * message is identified by the subscription from which it was pulled and its acknowledge id.
   * Auto-renewal will take place until the message is removed (see {@link #remove(String, String)}
   * or {@link #remove(String, Iterable)}).
   *
   * @param subscription the subscription from which the message has been pulled
   * @param ackId the message's acknowledge id
   */
  void add(String subscription, String ackId);

  /**
   * Adds new messages for which the acknowledge deadlined should be automatically renewed. The
   * messages are identified by the subscription from which they were pulled and their
   * acknowledge id. Auto-renewal will take place until the messages are removed (see
   * {@link #remove(String, String)} or {@link #remove(String, Iterable)}).
   *
   * @param subscription the subscription from which the messages have been pulled
   * @param ackIds the acknowledge ids of the messages
   */
  void add(String subscription, Iterable<String> ackIds);

  /**
   * Removes a message from this {@code AckDeadlineRenewer}. The message is identified by the
   * subscription from which it was pulled and its acknowledge id. Once the message is removed from
   * this {@code AckDeadlineRenewer}, automated ack deadline renewals will stop.
   *
   * @param subscription the subscription from which the message has been pulled
   * @param ackId the message's acknowledge id
   */
  void remove(String subscription, String ackId);

  /**
   * Removes messages from this {@code AckDeadlineRenewer}. The messages are identified by the
   * subscription from which they were pulled and their acknowledge id. Once the messages are
   * removed from this {@code AckDeadlineRenewer}, automated ack deadline renewals will stop.
   *
   * @param subscription the subscription from which the message has been pulled
   * @param ackIds the acknowledge ids of the messages
   */
  void remove(String subscription, Iterable<String> ackIds);
}
