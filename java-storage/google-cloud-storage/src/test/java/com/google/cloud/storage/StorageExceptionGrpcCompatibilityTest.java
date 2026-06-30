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

package com.google.cloud.storage;

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.cloud.BaseServiceException;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Any;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat.Printer;
import com.google.rpc.BadRequest;
import com.google.rpc.BadRequest.FieldViolation;
import com.google.rpc.DebugInfo;
import com.google.rpc.ErrorInfo;
import com.google.rpc.Help;
import com.google.rpc.Help.Link;
import com.google.rpc.LocalizedMessage;
import com.google.rpc.PreconditionFailure;
import com.google.rpc.QuotaFailure;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import java.util.List;
import org.junit.Test;

public final class StorageExceptionGrpcCompatibilityTest {

  @Test
  public void testCoalesce_CANCELLED() {
    doTestCoalesce(0, Code.CANCELLED);
  }

  @Test
  public void testCoalesce_UNKNOWN() {
    doTestCoalesce(0, Code.UNKNOWN);
  }

  @Test
  public void testCoalesce_INVALID_ARGUMENT() {
    doTestCoalesce(400, Code.INVALID_ARGUMENT);
  }

  @Test
  public void testCoalesce_DEADLINE_EXCEEDED() {
    doTestCoalesce(504, Code.DEADLINE_EXCEEDED);
  }

  @Test
  public void testCoalesce_NOT_FOUND() {
    doTestCoalesce(404, Code.NOT_FOUND);
  }

  @Test
  public void testCoalesce_ALREADY_EXISTS() {
    doTestCoalesce(409, Code.ALREADY_EXISTS);
  }

  @Test
  public void testCoalesce_PERMISSION_DENIED() {
    doTestCoalesce(403, Code.PERMISSION_DENIED);
  }

  @Test
  public void testCoalesce_RESOURCE_EXHAUSTED() {
    doTestCoalesce(429, Code.RESOURCE_EXHAUSTED);
  }

  @Test
  public void testCoalesce_FAILED_PRECONDITION() {
    doTestCoalesce(412, Code.FAILED_PRECONDITION);
  }

  @Test
  public void testCoalesce_ABORTED() {
    doTestCoalesce(409, Code.ABORTED);
  }

  @Test
  public void testCoalesce_OUT_OF_RANGE() {
    doTestCoalesce(400, Code.OUT_OF_RANGE);
  }

  @Test
  public void testCoalesce_UNIMPLEMENTED() {
    doTestCoalesce(501, Code.UNIMPLEMENTED);
  }

  @Test
  public void testCoalesce_INTERNAL() {
    doTestCoalesce(500, Code.INTERNAL);
  }

  @Test
  public void testCoalesce_UNAVAILABLE() {
    doTestCoalesce(503, Code.UNAVAILABLE);
  }

  @Test
  public void testCoalesce_DATA_LOSS() {
    doTestCoalesce(400, Code.DATA_LOSS);
  }

  @Test
  public void testCoalesce_UNAUTHENTICATED() {
    doTestCoalesce(401, Code.UNAUTHENTICATED);
  }

  @Test
  public void apiExceptionErrorDetails() throws Exception {
    ErrorInfo errorInfo =
        ErrorInfo.newBuilder()
            .setReason("STACKOUT")
            .setDomain("spanner.googlepais.com")
            .putMetadata("availableRegions", "us-central1,us-east2")
            .build();
    DebugInfo debugInfo =
        DebugInfo.newBuilder()
            .addStackEntries("HEAD")
            .addStackEntries("HEAD~1")
            .addStackEntries("HEAD~2")
            .addStackEntries("HEAD~3")
            .setDetail("some detail")
            .build();
    QuotaFailure quotaFailure =
        QuotaFailure.newBuilder()
            .addViolations(
                QuotaFailure.Violation.newBuilder()
                    .setSubject("clientip:127.0.3.3")
                    .setDescription("Daily limit")
                    .build())
            .build();
    PreconditionFailure preconditionFailure =
        PreconditionFailure.newBuilder()
            .addViolations(
                PreconditionFailure.Violation.newBuilder()
                    .setType("TOS")
                    .setSubject("google.com/cloud")
                    .setDescription("Terms of service not accepted")
                    .build())
            .build();
    BadRequest badRequest =
        BadRequest.newBuilder()
            .addFieldViolations(
                FieldViolation.newBuilder()
                    .setField("email_addresses[3].type[2]")
                    .setDescription("duplicate value 'WORK'")
                    .setReason("INVALID_EMAIL_ADDRESS_TYPE")
                    .setLocalizedMessage(
                        LocalizedMessage.newBuilder()
                            .setLocale("en-US")
                            .setMessage("Invalid email type: duplicate value")
                            .build())
                    .build())
            .build();
    Help help =
        Help.newBuilder()
            .addLinks(
                Link.newBuilder().setDescription("link1").setUrl("https://google.com").build())
            .build();
    List<Any> errors =
        ImmutableList.of(
            Any.pack(errorInfo),
            Any.pack(debugInfo),
            Any.pack(quotaFailure),
            Any.pack(preconditionFailure),
            Any.pack(badRequest),
            Any.pack(help));
    ErrorDetails errorDetails = ErrorDetails.builder().setRawErrorMessages(errors).build();
    ApiException ae =
        ApiExceptionFactory.createException(
            Code.OUT_OF_RANGE.toStatus().asRuntimeException(),
            GrpcStatusCode.of(Code.OUT_OF_RANGE),
            false,
            errorDetails);

    BaseServiceException se = StorageException.coalesce(ae);
    String message = se.getCause().getSuppressed()[0].getMessage();
    Printer printer = TextFormat.printer();
    assertAll(
        () -> assertThat(message).contains("ErrorDetails {"),
        () -> assertThat(message).contains(printer.shortDebugString(errorInfo)),
        () -> assertThat(message).contains(printer.shortDebugString(debugInfo)),
        () -> assertThat(message).contains(printer.shortDebugString(quotaFailure)),
        () -> assertThat(message).contains(printer.shortDebugString(preconditionFailure)),
        () -> assertThat(message).contains(printer.shortDebugString(badRequest)),
        () -> assertThat(message).contains(printer.shortDebugString(help)),
        () -> assertThat(message).contains("\t}"));
  }

  @SuppressWarnings("ThrowableNotThrown")
  @Test
  public void apiExceptionErrorDetails_onlyAttachedOnce() throws Exception {
    Help help =
        Help.newBuilder()
            .addLinks(
                Link.newBuilder().setDescription("link1").setUrl("https://google.com").build())
            .build();
    List<Any> errors = ImmutableList.of(Any.pack(help));
    ErrorDetails errorDetails = ErrorDetails.builder().setRawErrorMessages(errors).build();

    ApiException ex =
        ApiExceptionFactory.createException(
            Code.OUT_OF_RANGE.toStatus().asRuntimeException(),
            GrpcStatusCode.of(Code.OUT_OF_RANGE),
            false,
            errorDetails);

    // apply a coalesce to the exception -- similar to what a retry algorithm might do to determine
    // retryability. This is not ideal, as it is unpure but it is the way things are today with the
    // structure of storage exception and ApiException.
    BaseServiceException ignore1 = StorageException.coalesce(ex);
    BaseServiceException se = StorageException.coalesce(ex);

    String message = TestUtils.messagesToText(se);
    Printer printer = TextFormat.printer();
    assertAll(
        () -> assertThat(message).contains("ErrorDetails {"),
        () -> assertThat(message).contains(printer.shortDebugString(help)),
        () -> assertThat(message).contains("\t}"),
        () -> {
          // make sure the error details are only attached to the exception once
          String str = "ErrorDetails {";
          int indexOf1 = message.indexOf(str);
          int indexOf2 = message.indexOf(str, indexOf1 + str.length());
          assertThat(indexOf2).isEqualTo(-1);
        });
  }

  private void doTestCoalesce(int expectedCode, Code code) {
    Status status = code.toStatus();
    GrpcStatusCode statusCode = GrpcStatusCode.of(code);
    ErrorInfo errorInfo =
        ErrorInfo.newBuilder()
            .setReason("reason")
            .setDomain("global")
            .putMetadata("errors", "x")
            .build();

    DebugInfo debugInfo =
        DebugInfo.newBuilder()
            .setDetail(
                "bw-storage-dev-region-fine@default-223119.iam.gserviceaccount.com does not have"
                    + " storage.hmacKeys.list access to the Google Cloud project.")
            .build();

    ImmutableList<Any> anys = ImmutableList.of(Any.pack(errorInfo), Any.pack(debugInfo));
    ErrorDetails errorDetails = ErrorDetails.builder().setRawErrorMessages(anys).build();

    StatusRuntimeException cause =
        new StatusRuntimeException(status.withDescription(debugInfo.getDetail()));
    ApiException x = ApiExceptionFactory.createException(cause, statusCode, false, errorDetails);

    BaseServiceException ex = StorageException.coalesce(x);
    assertThat(ex.getCode()).isEqualTo(expectedCode);
    assertThat(ex.getReason()).isEqualTo(x.getReason());
    assertThat(ex.getMessage()).contains(x.getErrorDetails().getDebugInfo().getDetail());
    assertThat(ex).hasCauseThat().isEqualTo(x);
  }
}
