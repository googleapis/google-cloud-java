/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.spanner.SpannerExceptionFactory.extractErrorDetails;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ErrorDetails;
import javax.annotation.Nullable;

/** Exception thrown by Spanner when the transaction mutation limit has been exceeded. */
public class TransactionMutationLimitExceededException extends SpannerException {
  private static final long serialVersionUID = 1L;

  private static final String ERROR_MESSAGE = "The transaction contains too many mutations.";

  private static final String TRANSACTION_RESOURCE_LIMIT_EXCEEDED_MESSAGE =
      "Transaction resource limits exceeded";

  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  TransactionMutationLimitExceededException(
      DoNotConstructDirectly token,
      ErrorCode errorCode,
      String message,
      Throwable cause,
      @Nullable ApiException apiException) {
    super(token, errorCode, /* retryable= */ false, message, cause, apiException);
  }

  static boolean isTransactionMutationLimitException(ErrorCode code, String message) {
    return code == ErrorCode.INVALID_ARGUMENT
        && message != null
        && (message.contains(ERROR_MESSAGE)
            || message.contains(TRANSACTION_RESOURCE_LIMIT_EXCEEDED_MESSAGE));
  }

  static boolean isTransactionMutationLimitException(Throwable cause, ApiException apiException) {
    if (cause == null
        || cause.getMessage() == null
        || !(cause.getMessage().contains(ERROR_MESSAGE)
            || cause.getMessage().contains(TRANSACTION_RESOURCE_LIMIT_EXCEEDED_MESSAGE))) {
      return false;
    }
    // Spanner includes a hint that points to the Spanner limits documentation page when the error
    // was that the transaction mutation limit was exceeded. We use that here to identify the error,
    // as there is no other specific metadata in the error that identifies it (other than the error
    // message).
    ErrorDetails errorDetails = extractErrorDetails(cause, apiException);
    if (errorDetails != null && errorDetails.getHelp() != null) {
      return errorDetails.getHelp().getLinksCount() == 1
          && errorDetails
              .getHelp()
              .getLinks(0)
              .getDescription()
              .equals("Cloud Spanner limits documentation.")
          && errorDetails
              .getHelp()
              .getLinks(0)
              .getUrl()
              .equals("https://cloud.google.com/spanner/docs/limits");
    } else if (cause.getMessage().contains(TRANSACTION_RESOURCE_LIMIT_EXCEEDED_MESSAGE)) {
      // This more generic error does not contain any additional details.
      return true;
    }
    return false;
  }
}
