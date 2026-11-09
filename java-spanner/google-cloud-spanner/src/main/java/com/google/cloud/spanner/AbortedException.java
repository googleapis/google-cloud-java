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

package com.google.cloud.spanner;

import com.google.api.gax.rpc.ApiException;
import com.google.protobuf.ByteString;
import javax.annotation.Nullable;

/**
 * Exception thrown by Cloud Spanner when an operation detects that a transaction has aborted. This
 * type of error has its own subclass since it is often necessary to handle aborted differently to
 * other types of errors, most typically by retrying the transaction.
 */
public class AbortedException extends SpannerException {

  /**
   * Abort is not retryable per se: the operation request needs to change (generally to reflect a
   * new transaction attempt) before a retry can succeed.
   */
  private static final boolean IS_RETRYABLE = false;

  private ByteString transactionID;

  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  AbortedException(
      DoNotConstructDirectly token, @Nullable String message, @Nullable Throwable cause) {
    this(token, message, cause, null);
  }

  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  AbortedException(
      DoNotConstructDirectly token,
      @Nullable String message,
      @Nullable Throwable cause,
      @Nullable ApiException apiException) {
    super(token, ErrorCode.ABORTED, IS_RETRYABLE, message, cause, apiException);
    if (cause instanceof AbortedException) {
      this.transactionID = ((AbortedException) cause).getTransactionID();
    }
  }

  /**
   * Returns true if this aborted exception was returned by the emulator, and was caused by another
   * transaction already being active on the emulator.
   */
  public boolean isEmulatorOnlySupportsOneTransactionException() {
    return getMessage().endsWith("The emulator only supports one transaction at a time.");
  }

  void setTransactionID(ByteString transactionID) {
    this.transactionID = transactionID;
  }

  ByteString getTransactionID() {
    return this.transactionID;
  }
}
