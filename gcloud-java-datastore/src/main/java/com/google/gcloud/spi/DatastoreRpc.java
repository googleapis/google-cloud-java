/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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
package com.google.gcloud.spi;

import com.google.api.services.datastore.DatastoreV1.AllocateIdsRequest;
import com.google.api.services.datastore.DatastoreV1.AllocateIdsResponse;
import com.google.api.services.datastore.DatastoreV1.BeginTransactionRequest;
import com.google.api.services.datastore.DatastoreV1.BeginTransactionResponse;
import com.google.api.services.datastore.DatastoreV1.CommitRequest;
import com.google.api.services.datastore.DatastoreV1.CommitResponse;
import com.google.api.services.datastore.DatastoreV1.LookupRequest;
import com.google.api.services.datastore.DatastoreV1.LookupResponse;
import com.google.api.services.datastore.DatastoreV1.RollbackRequest;
import com.google.api.services.datastore.DatastoreV1.RollbackResponse;
import com.google.api.services.datastore.DatastoreV1.RunQueryRequest;
import com.google.api.services.datastore.DatastoreV1.RunQueryResponse;

/**
 * Provides access to the remote Datastore service.
 */
public interface DatastoreRpc {

  public class DatastoreRpcException extends Exception {

    /**
     * The reason for the exception.
     *
     * @see <a href="https://cloud.google.com/datastore/docs/concepts/errors#Error_Codes">Google
     *     Cloud Datastore error codes</a>
     */
    public enum Reason {

      ABORTED(true, "Request aborted", 409),
      DEADLINE_EXCEEDED(true, "Deadline exceeded", 403),
      FAILED_PRECONDITION(false, "Invalid request", 412),
      INTERNAL(false, "Server returned an error", 500),
      INVALID_ARGUMENT(false, "Request parameter has an invalid value", 400),
      PERMISSION_DENIED(false, "Unauthorized request", 403),
      RESOURCE_EXHAUSTED(false, "Quota exceeded", 402),
      UNAVAILABLE(true, "Could not reach service", 503);

      private final boolean retryable;
      private final String description;
      private final int httpStatus;

      private Reason(boolean retryable, String description, int httpStatus) {
        this.retryable = retryable;
        this.description = description;
        this.httpStatus = httpStatus;
      }

      public boolean retryable() {
        return retryable;
      }

      public String description() {
        return description;
      }

      public int httpStatus() {
        return httpStatus;
      }
    }

    private final String reason;
    private final int httpStatus;
    private final boolean retryable;

    public DatastoreRpcException(Reason reason) {
      this(reason.name(), reason.httpStatus, reason.retryable, reason.description);
    }

    public DatastoreRpcException(String reason, int httpStatus, boolean retryable, String message) {
      super(message);
      this.reason = reason;
      this.httpStatus = httpStatus;
      this.retryable = retryable;
    }

    public String reason() {
      return reason;
    }

    public int httpStatus() {
      return httpStatus;
    }

    public boolean retryable() {
      return retryable;
    }
  }

  AllocateIdsResponse allocateIds(AllocateIdsRequest request) throws DatastoreRpcException;

  BeginTransactionResponse beginTransaction(BeginTransactionRequest request)
      throws DatastoreRpcException;

  CommitResponse commit(CommitRequest request) throws DatastoreRpcException;

  LookupResponse lookup(LookupRequest request) throws DatastoreRpcException;

  RollbackResponse rollback(RollbackRequest request) throws DatastoreRpcException;

  RunQueryResponse runQuery(RunQueryRequest request) throws DatastoreRpcException;
}
