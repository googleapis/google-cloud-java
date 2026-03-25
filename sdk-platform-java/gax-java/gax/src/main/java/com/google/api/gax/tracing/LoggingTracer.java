/*
 * Copyright 2026 Google LLC
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

package com.google.api.gax.tracing;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.logging.LoggerProvider;
import com.google.api.gax.logging.LoggingUtils;
import com.google.rpc.ErrorInfo;
import java.util.HashMap;
import java.util.Map;

/**
 * An {@link ApiTracer} that logs actionable errors using {@link LoggingUtils} when an RPC attempt
 * fails.
 */
@BetaApi
@InternalApi
public class LoggingTracer extends BaseApiTracer {
  private static final LoggerProvider LOGGER_PROVIDER =
      LoggerProvider.forClazz(LoggingTracer.class);

  private final ApiTracerContext apiTracerContext;

  public LoggingTracer(ApiTracerContext apiTracerContext) {
    this.apiTracerContext = apiTracerContext;
  }

  @Override
  public void attemptFailed(Throwable error, org.threeten.bp.Duration delay) {
    recordActionableError(error);
  }

  @Override
  public void attemptFailedDuration(Throwable error, java.time.Duration delay) {
    recordActionableError(error);
  }

  @Override
  public void attemptFailedRetriesExhausted(Throwable error) {
    recordActionableError(error);
  }

  @Override
  public void attemptPermanentFailure(Throwable error) {
    recordActionableError(error);
  }

  private void recordActionableError(Throwable error) {
    Map<String, Object> logContext = new HashMap<>();

    if (apiTracerContext.rpcSystemName() != null) {
      logContext.put(
          ObservabilityAttributes.RPC_SYSTEM_NAME_ATTRIBUTE, apiTracerContext.rpcSystemName());
    }
    if (apiTracerContext.fullMethodName() != null) {
      logContext.put(
          ObservabilityAttributes.GRPC_RPC_METHOD_ATTRIBUTE, apiTracerContext.fullMethodName());
    }
    if (apiTracerContext.serverPort() != null) {
      logContext.put(ObservabilityAttributes.SERVER_PORT_ATTRIBUTE, apiTracerContext.serverPort());
    }
    if (apiTracerContext.libraryMetadata() != null
        && !apiTracerContext.libraryMetadata().isEmpty()) {
      if (apiTracerContext.libraryMetadata().repository() != null) {
        logContext.put(
            ObservabilityAttributes.REPO_ATTRIBUTE,
            apiTracerContext.libraryMetadata().repository());
      }
    }

    if (error != null) {
      logContext.put(
          ObservabilityAttributes.RPC_RESPONSE_STATUS_ATTRIBUTE,
          ObservabilityUtils.extractStatus(error));
    }

    ErrorInfo errorInfo = ObservabilityUtils.extractErrorInfo(error);
    if (errorInfo != null) {
      logContext.put("error.type", errorInfo.getReason());
      logContext.put("gcp.errors.domain", errorInfo.getDomain());
      for (Map.Entry<String, String> entry : errorInfo.getMetadataMap().entrySet()) {
        logContext.put("gcp.errors.metadata." + entry.getKey(), entry.getValue());
      }
    }

    String message = "Unknown Error";
    if (error != null) {
      message = error.getMessage() != null ? error.getMessage() : error.getClass().getName();
    }
    LoggingUtils.logActionableError(logContext, LOGGER_PROVIDER, message);
  }
}
