/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.grpc;

import com.google.api.gax.rpc.StatusCode;
import com.google.common.truth.Truth;
import io.grpc.Status;
import org.junit.jupiter.api.Test;

class GrpcStatusCodeTest {
  @Test
  void testGrpcCodeToStatusCode() {
    testCodes(StatusCode.Code.OK, Status.Code.OK);
    testCodes(StatusCode.Code.CANCELLED, Status.Code.CANCELLED);
    testCodes(StatusCode.Code.UNKNOWN, Status.Code.UNKNOWN);
    testCodes(StatusCode.Code.INVALID_ARGUMENT, Status.Code.INVALID_ARGUMENT);
    testCodes(StatusCode.Code.DEADLINE_EXCEEDED, Status.Code.DEADLINE_EXCEEDED);
    testCodes(StatusCode.Code.NOT_FOUND, Status.Code.NOT_FOUND);
    testCodes(StatusCode.Code.ALREADY_EXISTS, Status.Code.ALREADY_EXISTS);
    testCodes(StatusCode.Code.PERMISSION_DENIED, Status.Code.PERMISSION_DENIED);
    testCodes(StatusCode.Code.RESOURCE_EXHAUSTED, Status.Code.RESOURCE_EXHAUSTED);
    testCodes(StatusCode.Code.FAILED_PRECONDITION, Status.Code.FAILED_PRECONDITION);
    testCodes(StatusCode.Code.ABORTED, Status.Code.ABORTED);
    testCodes(StatusCode.Code.OUT_OF_RANGE, Status.Code.OUT_OF_RANGE);
    testCodes(StatusCode.Code.UNIMPLEMENTED, Status.Code.UNIMPLEMENTED);
    testCodes(StatusCode.Code.INTERNAL, Status.Code.INTERNAL);
    testCodes(StatusCode.Code.UNAVAILABLE, Status.Code.UNAVAILABLE);
    testCodes(StatusCode.Code.DATA_LOSS, Status.Code.DATA_LOSS);
    testCodes(StatusCode.Code.UNAUTHENTICATED, Status.Code.UNAUTHENTICATED);
  }

  private void testCodes(StatusCode.Code gaxCode, Status.Code grpcCode) {
    Truth.assertThat(GrpcStatusCode.grpcCodeToStatusCode(grpcCode)).isEqualTo(gaxCode);
  }
}
