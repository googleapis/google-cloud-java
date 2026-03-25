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
package com.google.api.gax.longrunning;

import com.google.api.gax.rpc.StatusCode;

/**
 * A snapshot of a long-running operation.
 *
 * <p>The metadata and response will have a structure defined by the particular long-running
 * operation that was initiated.
 */
public interface OperationSnapshot {

  /** The name of the operation. This is used for identifying the operation on the server. */
  String getName();

  /** Get metadata for the operation, which can change over the course of the operation. */
  Object getMetadata();

  /** Returns true if the operation is complete or failed, false otherwise. */
  boolean isDone();

  /**
   * If the operation is done and successful, returns the response; if the operation is not done or
   * if it is failed, returns null.
   */
  Object getResponse();

  /**
   * If the operation is done and it failed, returns the failure status code; if the operation is
   * not done or if it succeeded, returns null.
   */
  StatusCode getErrorCode();

  /**
   * If the operation is done and it failed, returns the error message; if the operation is not done
   * or if it succeeded, returns null.
   */
  String getErrorMessage();
}
