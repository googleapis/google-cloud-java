/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.executor.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Any;
import com.google.rpc.ErrorInfo;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CloudExecutorTest {

  private final CloudExecutor executor = new CloudExecutor() {};

  @Test
  public void toStatus_internalErrorWithNullReason_preservesErrorMessage() {
    SpannerException exception =
        SpannerExceptionFactory.newSpannerException(
            ErrorCode.INTERNAL, "Does not pass the heartbeat interval check.");

    Status status = executor.toStatus(exception);

    assertEquals(Status.Code.INTERNAL, status.getCode());
    assertEquals("INTERNAL: Does not pass the heartbeat interval check.", status.getDescription());
  }

  @Test
  public void toStatus_internalErrorWithReason_appendsReasonToErrorMessage() {
    ErrorInfo errorInfo = ErrorInfo.newBuilder().setReason("SOME_REASON").build();
    ErrorDetails errorDetails =
        ErrorDetails.builder().setRawErrorMessages(ImmutableList.of(Any.pack(errorInfo))).build();
    ApiException apiException =
        ApiExceptionFactory.createException(
            "Internal failure",
            null,
            GrpcStatusCode.of(Status.Code.INTERNAL),
            false,
            errorDetails);
    SpannerException exception = SpannerExceptionFactory.newSpannerException(apiException);

    Status status = executor.toStatus(exception);

    assertEquals(Status.Code.INTERNAL, status.getCode());
    assertEquals("INTERNAL: Internal failure: SOME_REASON", status.getDescription());
  }

  @Test
  public void toStatus_internalErrorWithRpcStatusDetails_preservesErrorMessageAndDetails() {
    ErrorInfo detail = ErrorInfo.newBuilder().setReason("DETAIL_REASON").build();
    com.google.rpc.Status rpcStatus =
        com.google.rpc.Status.newBuilder()
            .setCode(Status.Code.INTERNAL.value())
            .setMessage("msg")
            .addDetails(Any.pack(detail))
            .build();
    Metadata trailers = new Metadata();
    Metadata.Key<byte[]> statusDetailsKey =
        Metadata.Key.of("grpc-status-details-bin", Metadata.BINARY_BYTE_MARSHALLER);
    trailers.put(statusDetailsKey, rpcStatus.toByteArray());
    StatusRuntimeException statusException =
        new StatusRuntimeException(Status.INTERNAL.withDescription("msg"), trailers);
    SpannerException exception = SpannerExceptionFactory.newSpannerException(statusException);

    Status status = executor.toStatus(exception);

    assertEquals(Status.Code.INTERNAL, status.getCode());
    String description = status.getDescription();
    assertTrue(description.startsWith("INTERNAL: msg"));
    assertTrue(description.contains("\nError detail: "));
    assertTrue(description.contains("DETAIL_REASON"));
  }

  @Test
  public void toStatus_nonInternalError_preservesErrorMessage() {
    SpannerException exception =
        SpannerExceptionFactory.newSpannerException(ErrorCode.ABORTED, "Transaction aborted");

    Status status = executor.toStatus(exception);

    assertEquals(Status.Code.ABORTED, status.getCode());
    assertEquals("ABORTED: Transaction aborted", status.getDescription());
  }
}
