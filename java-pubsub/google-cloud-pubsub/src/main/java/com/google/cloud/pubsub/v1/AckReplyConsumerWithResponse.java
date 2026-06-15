/*
 * Copyright 2022 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;

/**
 * Acknowledging a message in Pub/Sub means that you are done with it, and it will not be delivered
 * to this subscription again. You should avoid acknowledging messages until you have *finished*
 * processing them, so that in the event of a failure, you receive the message again.
 *
 * <p>If exactly-once delivery is enabled on the subscription, the future returned by the ack/nack
 * methods track the state of acknowledgement operation by the server. If the future completes
 * successfully, the message is guaranteed NOT to be re-delivered. Otherwise, the future will
 * contain an exception with more details about the failure and the message may be re-delivered.
 *
 * <p>If exactly-once delivery is NOT enabled on the subscription, the future returns immediately
 * with an AckResponse.SUCCESS. Because re-deliveries are possible, you should ensure that your
 * processing code is idempotent, as you may receive any given message more than once.
 */
@BetaApi(
    "This is a preview feature. For more details, see"
        + " https://cloud.google.com/pubsub/docs/exactly-once-delivery.")
public interface AckReplyConsumerWithResponse {
  /**
   * Acknowledges that the message has been successfully processed. The service will not send the
   * message again.
   *
   * <p>A future representing the server response is returned
   */
  ApiFuture<AckResponse> ack();

  /**
   * Signals that the message has not been successfully processed. The service should resend the
   * message.
   *
   * <p>A future representing the server response is returned
   */
  ApiFuture<AckResponse> nack();
}
