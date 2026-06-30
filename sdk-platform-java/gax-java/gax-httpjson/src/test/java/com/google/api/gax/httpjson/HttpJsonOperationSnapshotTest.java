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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.gax.rpc.StatusCode.Code;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class HttpJsonOperationSnapshotTest {

  @Test
  void newBuilderTestNoError() {
    HttpJsonOperationSnapshot testOperationSnapshot =
        HttpJsonOperationSnapshot.newBuilder()
            .setName("snapshot0")
            .setMetadata("Los Angeles")
            .setDone(true)
            .setResponse("Atlanta")
            .setError(0, "no error")
            .build();

    assertEquals("no error", testOperationSnapshot.getErrorMessage());
    assertEquals(HttpJsonStatusCode.of(Code.OK), testOperationSnapshot.getErrorCode());
    assertTrue(testOperationSnapshot.isDone());
  }

  @Test
  void newBuilderTestWithError() {
    HttpJsonOperationSnapshot testOperationSnapshot =
        HttpJsonOperationSnapshot.newBuilder()
            .setName("snapshot1")
            .setMetadata("Austin")
            .setDone(true)
            .setResponse(new ArrayList<Integer>())
            .setError(403, "Forbidden")
            .build();

    assertEquals(testOperationSnapshot.getErrorMessage(), "Forbidden");
    assertEquals(testOperationSnapshot.getErrorCode(), HttpJsonStatusCode.of(403));
    assertTrue(testOperationSnapshot.isDone());
  }

  @Test
  void newBuilderTestNotDone() {
    HttpJsonOperationSnapshot testOperationSnapshot =
        HttpJsonOperationSnapshot.newBuilder()
            .setName("snapshot2")
            .setMetadata("Chicago")
            .setDone(false)
            .setResponse(new ArrayList<Integer>())
            .setError(0, "no error")
            .build();

    assertEquals("no error", testOperationSnapshot.getErrorMessage());
    assertEquals(HttpJsonStatusCode.of(Code.OK), testOperationSnapshot.getErrorCode());
    assertFalse(testOperationSnapshot.isDone());
  }
}
