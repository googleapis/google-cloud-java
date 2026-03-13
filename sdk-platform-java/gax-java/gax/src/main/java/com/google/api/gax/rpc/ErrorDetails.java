/*
 * Copyright 2022 Google LLC
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
package com.google.api.gax.rpc;

import com.google.auto.value.AutoValue;
import com.google.common.annotations.VisibleForTesting;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.rpc.BadRequest;
import com.google.rpc.DebugInfo;
import com.google.rpc.ErrorInfo;
import com.google.rpc.Help;
import com.google.rpc.LocalizedMessage;
import com.google.rpc.PreconditionFailure;
import com.google.rpc.QuotaFailure;
import com.google.rpc.RequestInfo;
import com.google.rpc.ResourceInfo;
import com.google.rpc.RetryInfo;
import java.util.List;
import javax.annotation.Nullable;

/** This class contains a list of standard error messages that returns from server. */
@AutoValue
public abstract class ErrorDetails {

  /**
   * This is the most important and special error message. It describes the cause of the error with
   * structured details that both humans and applications can depend on.
   */
  @Nullable
  public ErrorInfo getErrorInfo() {
    return unpack(ErrorInfo.class);
  }

  /**
   * Describes when the clients can retry a failed request. Clients could ignore the recommendation
   * here or retry when this information is missing from error responses.
   */
  @Nullable
  public RetryInfo getRetryInfo() {
    return unpack(RetryInfo.class);
  }

  /** Describes additional debugging info. */
  @Nullable
  public DebugInfo getDebugInfo() {
    return unpack(DebugInfo.class);
  }

  /** Describes how a quota check failed. */
  @Nullable
  public QuotaFailure getQuotaFailure() {
    return unpack(QuotaFailure.class);
  }

  /** Describes what preconditions have failed. */
  @Nullable
  public PreconditionFailure getPreconditionFailure() {
    return unpack(PreconditionFailure.class);
  }

  /**
   * Describes violations in a client request. This error type focuses on the syntactic aspects of
   * the request.
   */
  @Nullable
  public BadRequest getBadRequest() {
    return unpack(BadRequest.class);
  }

  /**
   * Contains metadata about the request that clients can attach when filing a bug or providing
   * other forms of feedback.
   */
  @Nullable
  public RequestInfo getRequestInfo() {
    return unpack(RequestInfo.class);
  }

  /** Describes the resource that is being accessed. */
  @Nullable
  public ResourceInfo getResourceInfo() {
    return unpack(ResourceInfo.class);
  }

  /** Provides links to documentation or for performing an out-of-band action. */
  @Nullable
  public Help getHelp() {
    return unpack(Help.class);
  }

  /**
   * Provides a localized error message that is safe to return to the user which can be attached to
   * an RPC error
   */
  @Nullable
  public LocalizedMessage getLocalizedMessage() {
    return unpack(LocalizedMessage.class);
  }

  /**
   * Attempt to unpack a non-default error message type {@code T}. The first occurrence of a {@code
   * T} is returned, null otherwise.
   */
  @Nullable
  public <T extends Message> T getMessage(Class<T> messageClass) {
    return unpack(messageClass);
  }

  /** This is a list of raw/unparsed error messages that returns from server. */
  @Nullable
  abstract List<Any> getRawErrorMessages();

  public static Builder builder() {
    return new AutoValue_ErrorDetails.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder setRawErrorMessages(List<Any> rawErrorMessages);

    public abstract ErrorDetails build();
  }

  @VisibleForTesting
  <T extends Message> T unpack(Class<T> errorTypeClazz) {
    List<Any> rawErrorMessages = getRawErrorMessages();
    if (rawErrorMessages == null) {
      return null;
    }
    for (Any detail : rawErrorMessages) {
      if (!detail.is(errorTypeClazz)) {
        continue;
      }
      try {
        return detail.unpack(errorTypeClazz);
      } catch (InvalidProtocolBufferException e) {
        throw new ProtocolBufferParsingException(
            String.format(
                "Failed to unpack %s from raw error messages", errorTypeClazz.getSimpleName()),
            e);
      }
    }
    return null;
  }
}
