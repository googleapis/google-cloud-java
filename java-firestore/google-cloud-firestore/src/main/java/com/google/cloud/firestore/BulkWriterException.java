/*
 * Copyright 2020 Google LLC
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

import com.google.cloud.firestore.BulkWriter.OperationType;
import io.grpc.Status;

/** The error thrown when a BulkWriter operation fails. */
public final class BulkWriterException extends FirestoreException {
  private final Status status;
  private final String message;
  private final DocumentReference documentReference;
  private final OperationType operationType;
  private final int failedAttempts;

  public BulkWriterException(
      Status status,
      String message,
      DocumentReference documentReference,
      OperationType operationType,
      int failedAttempts) {
    super(message, status);
    this.status = status;
    this.message = message;
    this.documentReference = documentReference;
    this.operationType = operationType;
    this.failedAttempts = failedAttempts;
  }

  /**
   * @return The status code of the error.
   */
  public Status getStatus() {
    return status;
  }

  /**
   * @return The error message of the error.
   */
  public String getMessage() {
    return message;
  }

  /**
   * @return The DocumentReference the operation was performed on.
   */
  public DocumentReference getDocumentReference() {
    return documentReference;
  }

  /**
   * @return The type of operation performed.
   */
  public OperationType getOperationType() {
    return operationType;
  }

  /**
   * @return How many times this operation has been attempted unsuccessfully.
   */
  public int getFailedAttempts() {
    return failedAttempts;
  }
}
