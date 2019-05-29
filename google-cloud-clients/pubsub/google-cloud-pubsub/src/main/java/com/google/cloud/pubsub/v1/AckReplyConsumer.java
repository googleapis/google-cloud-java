/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.pubsub.v1;

/** Accepts a reply, sending it to the service. */
public interface AckReplyConsumer {
  /**
   * Acknowledges that the message has been successfully processed. The service will not send the
   * message again.
   */
  void ack();

  /**
   * Signals that the message has not been successfully processed. The service should resend the
   * message.
   */
  void nack();
}
