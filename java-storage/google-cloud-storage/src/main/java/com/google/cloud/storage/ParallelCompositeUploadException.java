/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage;

import com.google.api.core.ApiFuture;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.StatusCode;
import io.grpc.Status.Code;
import java.util.List;

/**
 * An exception which provides access to created objects during a Parallel Composite Upload that did
 * not finish successfully.
 *
 * <p>This exception can occur when calling any method on the {@link
 * java.nio.channels.WritableByteChannel} returned from {@link BlobWriteSession#open()}, in which
 * case it will be the cause of a {@link StorageException}.
 *
 * <p>Similarly, this exception will be the cause of a {@link
 * java.util.concurrent.CancellationException} thrown by the {@link BlobWriteSession#getResult()}.
 */
public final class ParallelCompositeUploadException extends ApiException {

  private final ApiFuture<List<BlobId>> createdObjects;

  private ParallelCompositeUploadException(
      Throwable cause,
      StatusCode statusCode,
      ErrorDetails errorDetails,
      ApiFuture<List<BlobId>> createdObjects) {
    super(cause, statusCode, false, errorDetails);
    this.createdObjects = createdObjects;
  }

  /**
   * A future list of the {@link BlobId}s which were created during the Parallel Composite Upload
   * but may not have successfully been cleaned up.
   */
  public ApiFuture<List<BlobId>> getCreatedObjects() {
    return createdObjects;
  }

  static ParallelCompositeUploadException of(Throwable t, ApiFuture<List<BlobId>> createdObjects) {
    StatusCode statusCode;
    ErrorDetails errorDetails;

    Throwable cause = t;
    if (t instanceof StorageException && t.getCause() != null) {
      cause = t.getCause();
    }

    if (cause instanceof ApiException) {
      ApiException apiException = (ApiException) cause;
      statusCode = apiException.getStatusCode();
      errorDetails = apiException.getErrorDetails();
    } else {
      statusCode = GrpcStatusCode.of(Code.UNKNOWN);
      errorDetails = ErrorDetails.builder().build();
    }
    return new ParallelCompositeUploadException(cause, statusCode, errorDetails, createdObjects);
  }
}
