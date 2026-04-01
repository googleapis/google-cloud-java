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

import com.google.api.core.InternalApi;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.longrunning.Operation;

/**
 * Implementation of OperationSnapshot based on REST transport.
 *
 * <p>Public for technical reasons. For internal use only.
 */
@InternalApi
public class HttpJsonOperationSnapshot implements OperationSnapshot {
  private final String name;
  private final Object metadata;
  private final boolean done;
  private final Object response;
  private final StatusCode errorCode;
  private final String errorMessage;

  private HttpJsonOperationSnapshot(
      String name,
      Object metadata,
      boolean done,
      Object response,
      StatusCode errorCode,
      String errorMessage) {
    this.name = name;
    this.metadata = metadata;
    this.done = done;
    this.response = response;
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  /** {@inheritDoc} */
  @Override
  public String getName() {
    return this.name;
  }

  /** {@inheritDoc} */
  @Override
  public Object getMetadata() {
    return this.metadata;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isDone() {
    return done;
  }

  /** {@inheritDoc} */
  @Override
  public Object getResponse() {
    return this.response;
  }

  /** {@inheritDoc} */
  @Override
  public StatusCode getErrorCode() {
    return this.errorCode;
  }

  /** {@inheritDoc} */
  @Override
  public String getErrorMessage() {
    return this.errorMessage;
  }

  public static HttpJsonOperationSnapshot create(Operation operation) {
    return newBuilder().setOperation(operation).build();
  }

  public static Builder newBuilder() {
    return new HttpJsonOperationSnapshot.Builder();
  }

  public static class Builder {
    private String name;
    private Object metadata;
    private boolean done;
    private Object response;
    private StatusCode errorCode;
    private String errorMessage;

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setMetadata(Object metadata) {
      this.metadata = metadata;
      return this;
    }

    public Builder setDone(boolean done) {
      this.done = done;
      return this;
    }

    public Builder setResponse(Object response) {
      this.response = response;
      return this;
    }

    public Builder setError(int httpStatus, String errorMessage) {
      this.errorCode =
          httpStatus == 0 ? HttpJsonStatusCode.of(Code.OK) : HttpJsonStatusCode.of(httpStatus);
      this.errorMessage = errorMessage;
      return this;
    }

    private Builder setOperation(Operation operation) {
      this.name = operation.getName();
      this.done = operation.getDone();
      this.response = operation.getResponse();
      this.metadata = operation.getMetadata();
      this.errorCode =
          HttpJsonStatusCode.of(com.google.rpc.Code.forNumber(operation.getError().getCode()));
      this.errorMessage = operation.getError().getMessage();
      return this;
    }

    public HttpJsonOperationSnapshot build() {
      return new HttpJsonOperationSnapshot(name, metadata, done, response, errorCode, errorMessage);
    }
  }
}
