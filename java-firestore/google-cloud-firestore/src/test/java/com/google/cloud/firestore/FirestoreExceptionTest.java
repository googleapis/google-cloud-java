/*
 * Copyright 2025 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import io.grpc.Status;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/** Unit tests for the FirestoreException class. */
@RunWith(MockitoJUnitRunner.class)
public class FirestoreExceptionTest {
  @Test
  public void testConstructorWithReasonAndStatus() {
    String reason = "Aborted operation";
    Status status = Status.ABORTED;
    FirestoreException exception = new FirestoreException(reason, status);

    assertEquals(reason, exception.getMessage());
    assertEquals(status, exception.getStatus());
    assertNull(exception.getCause());
    assertEquals(status.getCode().value(), exception.getCode());
    assertFalse(exception.isRetryable());
  }

  @Test
  public void testForInvalidArgument() {
    String messageTemplate = "Invalid argument supplied: %s";
    String argument = "collectionId";
    String expectedMessage = String.format(messageTemplate, argument);

    FirestoreException exception = FirestoreException.forInvalidArgument(messageTemplate, argument);

    assertEquals(expectedMessage, exception.getMessage());
    assertEquals(Status.INVALID_ARGUMENT, exception.getStatus());
    assertNull(exception.getCause());
    assertEquals(Status.INVALID_ARGUMENT.getCode().value(), exception.getCode());
    assertFalse(exception.isRetryable());
  }

  @Test
  public void testForServerRejection() {
    Status status = Status.PERMISSION_DENIED;
    String expectedMessage = "User is not authorized.";

    FirestoreException exception = FirestoreException.forServerRejection(status, expectedMessage);

    assertEquals(expectedMessage, exception.getMessage());
    assertEquals(status, exception.getStatus());
    assertNull(exception.getCause());
    assertEquals(status.getCode().value(), exception.getCode());
    assertFalse(exception.isRetryable());
  }

  @Test
  public void testForServerRejectionWithCause() {
    Status status = Status.INTERNAL;
    String expectedMessage = "Database connection lost.";
    Throwable cause = new IllegalStateException("DB connection failed");

    FirestoreException exception =
        FirestoreException.forServerRejection(status, cause, expectedMessage);

    assertEquals(expectedMessage, exception.getMessage());
    assertEquals(status, exception.getStatus());
    assertEquals(cause, exception.getCause());
    assertEquals(status.getCode().value(), exception.getCode());
    assertFalse(exception.isRetryable());
  }

  @Test
  public void testForIOException() {
    IOException ioException = new IOException("Simulated network read error");
    // The 'retryable' argument is passed, but BaseGrpcServiceException determines actual
    // retryability for IOExceptions.
    boolean retryable = true;

    FirestoreException exception = FirestoreException.forIOException(ioException, retryable);

    assertEquals(ioException.getMessage(), exception.getMessage());
    assertEquals(ioException, exception.getCause());
    // BaseGrpcServiceException classifies generic IOExceptions as non-retryable.
    assertFalse(exception.isRetryable());
    assertNull(exception.getStatus());
    // BaseGrpcServiceException extracts Code from HttpResponseException, or set it to
    // UNKNOWN_CODE, which is 0.
    assertEquals(0, exception.getCode());
  }

  @Test
  public void testForApiException() {
    String apiExceptionMessage = "Generic API error details";
    boolean apiExceptionRetryable = true;
    final StatusCode.Code apiStatusCodeCode = StatusCode.Code.DEADLINE_EXCEEDED;

    ApiException realApiException =
        new ApiException(
            apiExceptionMessage,
            new RuntimeException("Underlying cause for ApiException"),
            GrpcStatusCode.of(Status.Code.DEADLINE_EXCEEDED),
            apiExceptionRetryable);

    FirestoreException exception = FirestoreException.forApiException(realApiException);

    assertEquals(apiExceptionMessage, exception.getMessage());
    assertEquals(realApiException, exception.getCause());
    assertEquals(Status.DEADLINE_EXCEEDED.getCode(), exception.getStatus().getCode());
    assertTrue(exception.isRetryable());
    assertEquals(apiStatusCodeCode.getHttpStatusCode(), exception.getCode());
  }

  @Test
  public void testForApiExceptionWithCustomMessage() {
    String customMessage = "A specific problem occurred during API call.";
    boolean apiExceptionRetryable = false;
    final StatusCode.Code apiStatusCodeCode = StatusCode.Code.NOT_FOUND;

    ApiException realApiException =
        new ApiException(
            "This message from ApiException will be overridden by custom message",
            new IllegalStateException("Original API problem"),
            GrpcStatusCode.of(Status.Code.NOT_FOUND),
            apiExceptionRetryable);

    FirestoreException exception =
        FirestoreException.forApiException(realApiException, customMessage);

    assertEquals(customMessage, exception.getMessage());
    assertEquals(realApiException, exception.getCause());
    assertEquals(Status.NOT_FOUND.getCode(), exception.getStatus().getCode());
    assertFalse(exception.isRetryable());
    assertEquals(apiStatusCodeCode.getHttpStatusCode(), exception.getCode());
  }

  @Test
  public void testGetStatusFromDirectStatusCreation() {
    Status expectedStatus = Status.RESOURCE_EXHAUSTED.withDescription("Quota exceeded.");
    FirestoreException exception = new FirestoreException("Quota limits hit.", expectedStatus);
    assertEquals(expectedStatus, exception.getStatus());
  }
}
