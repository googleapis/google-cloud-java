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

import com.google.api.core.SettableApiFuture;
import java.util.Optional;

public class AckRequestData {
  private final String ackId;
  private final Optional<SettableApiFuture<AckResponse>> messageFuture;

  protected AckRequestData(Builder builder) {
    this.ackId = builder.ackId;
    this.messageFuture = builder.messageFuture;
  }

  public String getAckId() {
    return ackId;
  }

  public SettableApiFuture<AckResponse> getMessageFutureIfExists() {
    return this.messageFuture.orElse(null);
  }

  public AckRequestData setResponse(AckResponse ackResponse, boolean setResponseOnSuccess) {
    if (this.messageFuture.isPresent() && !this.messageFuture.get().isDone()) {
      switch (ackResponse) {
        case SUCCESSFUL:
          if (setResponseOnSuccess) {
            this.messageFuture.get().set(ackResponse);
          }
          break;
        case INVALID:
        case OTHER:
        case PERMISSION_DENIED:
        case FAILED_PRECONDITION:
          // Non-succesful messages will get set for both acks, nacks, and modacks
          this.messageFuture.get().set(ackResponse);
          break;
      }
    }
    return this;
  }

  public boolean hasMessageFuture() {
    return this.messageFuture.isPresent();
  }

  public static Builder newBuilder(String ackId) {
    return new Builder(ackId);
  }

  /** Builder of {@link AckRequestData AckRequestData}. */
  protected static final class Builder {
    private final String ackId;
    private Optional<SettableApiFuture<AckResponse>> messageFuture = Optional.empty();

    protected Builder(String ackId) {
      this.ackId = ackId;
    }

    public Builder setMessageFuture(SettableApiFuture<AckResponse> messageFuture) {
      this.messageFuture = Optional.of(messageFuture);
      return this;
    }

    public AckRequestData build() {
      return new AckRequestData(this);
    }
  }
}
