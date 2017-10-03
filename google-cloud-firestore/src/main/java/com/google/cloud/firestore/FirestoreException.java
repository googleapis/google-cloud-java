/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.firestore;

import com.google.cloud.http.BaseHttpServiceException;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.Set;

/** A Firestore Service exception. */
public final class FirestoreException extends BaseHttpServiceException {

  private static final Set<Error> RETRYABLE_ERRORS =
      ImmutableSet.of(
          new Error(10, "ABORTED", false),
          new Error(4, "DEADLINE_EXCEEDED", false),
          new Error(14, "UNAVAILABLE", true));
  private static final long serialVersionUID = 9100921023984662143L;

  private FirestoreException(int code, String message, String reason) {
    this(code, message, reason, true, null);
  }

  private FirestoreException(
      int code, String message, String reason, boolean idempotent, Throwable cause) {
    super(code, message, reason, idempotent, RETRYABLE_ERRORS, cause);
  }

  private FirestoreException(IOException exception) {
    super(exception, true, RETRYABLE_ERRORS);
  }

  /**
   * Create a FirestoreException with {@code FAILED_PRECONDITION} reason and the {@code message} in
   * a nested exception.
   *
   * @return The FirestoreException
   */
  static FirestoreException invalidState(String message, Object... params) {
    return new FirestoreException(
        UNKNOWN_CODE, String.format(message, params), "FAILED_PRECONDITION");
  }

  /**
   * Create a FirestoreException with {@code FAILED_PRECONDITION} reason and the {@code message} in
   * a nested exception.
   *
   * @return The FirestoreException
   */
  static FirestoreException serverRejected(String message, Object... params) {
    return new FirestoreException(UNKNOWN_CODE, String.format(message, params), "CANCELLED");
  }

  /**
   * Create a FirestoreException with {@code FAILED_PRECONDITION} reason and the {@code message} in
   * a nested exception.
   *
   * @return The FirestoreException
   */
  static FirestoreException networkException(IOException exception) {
    return new FirestoreException(exception);
  }
}
