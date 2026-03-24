/*
 * Copyright 2021 Google LLC
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
package com.google.api.gax.httpjson;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.api.gax.rpc.StatusCode.Code;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class HttpJsonStatusCodeTest {

  @Test
  void rpcCodeToStatusCodeTest() {
    Set<Code> allCodes = new HashSet<>();
    for (com.google.rpc.Code rpcCode : com.google.rpc.Code.values()) {
      Code statusCode;
      try {
        statusCode = HttpJsonStatusCode.rpcCodeToStatusCode(rpcCode);
      } catch (IllegalArgumentException e) {
        if (rpcCode != com.google.rpc.Code.UNRECOGNIZED) {
          fail("Unrecognized com.google.rpc.Code found " + rpcCode);
        }
        continue;
      }

      assertThat(statusCode).isNotNull();
      allCodes.add(statusCode);
    }

    assertThat(Code.values()).asList().containsExactlyElementsIn(allCodes);
  }

  @Test
  void httpStatusToStatusCodeTest() {
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(200)).isEqualTo(Code.OK);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(201)).isEqualTo(Code.OK);

    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(400)).isEqualTo(Code.INVALID_ARGUMENT);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(401)).isEqualTo(Code.UNAUTHENTICATED);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(403)).isEqualTo(Code.PERMISSION_DENIED);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(404)).isEqualTo(Code.NOT_FOUND);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(409)).isEqualTo(Code.ABORTED);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(416)).isEqualTo(Code.OUT_OF_RANGE);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(429)).isEqualTo(Code.RESOURCE_EXHAUSTED);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(499)).isEqualTo(Code.CANCELLED);

    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(405)).isEqualTo(Code.FAILED_PRECONDITION);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(408)).isEqualTo(Code.FAILED_PRECONDITION);

    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(500)).isEqualTo(Code.INTERNAL);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(501)).isEqualTo(Code.UNIMPLEMENTED);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(502)).isEqualTo(Code.INTERNAL);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(503)).isEqualTo(Code.UNAVAILABLE);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(504)).isEqualTo(Code.DEADLINE_EXCEEDED);

    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(100)).isEqualTo(Code.UNKNOWN);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(300)).isEqualTo(Code.UNKNOWN);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(302)).isEqualTo(Code.UNKNOWN);
    assertThat(HttpJsonStatusCode.httpStatusToStatusCode(600)).isEqualTo(Code.UNKNOWN);
  }
}
