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

import com.google.api.core.InternalApi;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.NullMarked;

/**
 * A composite implementation of {@link ApiTracer} that delegates all tracing events to a list of
 * underlying tracers.
 *
 * <p>For internal use only.
 */
@NullMarked
@InternalApi
class CompositeTracer extends BaseApiTracer {
  private static final Scope NOOP_SCOPE = () -> {};

  private final List<ApiTracer> children;

  public CompositeTracer(List<ApiTracer> children) {
    this.children = ImmutableList.copyOf(children);
  }

  // Unstubbed Mockito mocks of ApiTracer may return null despite @NullMarked, and Error is caught
  // alongside RuntimeException solely to close already-opened scopes before rethrowing.
  @SuppressWarnings({"java:S2589", "java:S1181"})
  @Override
  public Scope inScope() {
    if (children.isEmpty()) {
      return NOOP_SCOPE;
    }
    if (children.size() == 1) {
      Scope scope = children.get(0).inScope();
      return scope != null ? scope : NOOP_SCOPE;
    }
    final List<Scope> childScopes = new ArrayList<>(children.size());

    try {
      for (ApiTracer child : children) {
        Scope childScope = child.inScope();
        if (childScope != null) {
          childScopes.add(childScope);
        }
      }
    } catch (RuntimeException | Error e) {
      for (int i = childScopes.size() - 1; i >= 0; i--) {
        try {
          childScopes.get(i).close();
        } catch (RuntimeException | Error suppressed) {
          e.addSuppressed(suppressed);
        }
      }
      throw e;
    }

    if (childScopes.isEmpty()) {
      return NOOP_SCOPE;
    }
    if (childScopes.size() == 1) {
      return childScopes.get(0);
    }

    // Scope is thread-bound and must be closed on the same thread that opened it.
    return new Scope() {
      private boolean closed;

      @Override
      public void close() {
        if (closed) {
          return;
        }
        closed = true;
        Throwable primaryError = null;
        for (int i = childScopes.size() - 1; i >= 0; i--) {
          try {
            childScopes.get(i).close();
          } catch (RuntimeException | Error e) {
            if (primaryError == null) {
              primaryError = e;
            } else {
              primaryError.addSuppressed(e);
            }
          }
        }
        if (primaryError instanceof RuntimeException) {
          throw (RuntimeException) primaryError;
        }
        if (primaryError instanceof Error) {
          throw (Error) primaryError;
        }
      }
    };
  }

  @Override
  public void operationSucceeded() {
    try (Scope ignored = inScope()) {
      for (int i = children.size() - 1; i >= 0; i--) {
        children.get(i).operationSucceeded();
      }
    }
  }

  @Override
  public void operationCancelled() {
    try (Scope ignored = inScope()) {
      for (int i = children.size() - 1; i >= 0; i--) {
        children.get(i).operationCancelled();
      }
    }
  }

  @Override
  public void operationFailed(Throwable error) {
    try (Scope ignored = inScope()) {
      for (int i = children.size() - 1; i >= 0; i--) {
        children.get(i).operationFailed(error);
      }
    }
  }

  @Override
  public void connectionSelected(String id) {
    for (ApiTracer child : children) {
      child.connectionSelected(id);
    }
  }

  @Override
  @Deprecated
  public void attemptStarted(int attemptNumber) {
    for (ApiTracer child : children) {
      child.attemptStarted(attemptNumber);
    }
  }

  @Override
  public void attemptStarted(Object request, int attemptNumber) {
    for (ApiTracer child : children) {
      child.attemptStarted(request, attemptNumber);
    }
  }

  @Override
  public void attemptSucceeded() {
    try (Scope ignored = inScope()) {
      for (int i = children.size() - 1; i >= 0; i--) {
        children.get(i).attemptSucceeded();
      }
    }
  }

  @Override
  public void attemptCancelled() {
    try (Scope ignored = inScope()) {
      for (int i = children.size() - 1; i >= 0; i--) {
        children.get(i).attemptCancelled();
      }
    }
  }

  @Override
  public void attemptFailed(Throwable error, org.threeten.bp.Duration delay) {
    try (Scope ignored = inScope()) {
      for (int i = children.size() - 1; i >= 0; i--) {
        children.get(i).attemptFailed(error, delay);
      }
    }
  }

  @Override
  public void attemptFailedDuration(Throwable error, java.time.Duration delay) {
    try (Scope ignored = inScope()) {
      for (int i = children.size() - 1; i >= 0; i--) {
        children.get(i).attemptFailedDuration(error, delay);
      }
    }
  }

  @Override
  public void attemptFailedRetriesExhausted(Throwable error) {
    try (Scope ignored = inScope()) {
      for (int i = children.size() - 1; i >= 0; i--) {
        children.get(i).attemptFailedRetriesExhausted(error);
      }
    }
  }

  @Override
  public void attemptPermanentFailure(Throwable error) {
    try (Scope ignored = inScope()) {
      for (int i = children.size() - 1; i >= 0; i--) {
        children.get(i).attemptPermanentFailure(error);
      }
    }
  }

  @Override
  public void lroStartFailed(Throwable error) {
    for (int i = children.size() - 1; i >= 0; i--) {
      children.get(i).lroStartFailed(error);
    }
  }

  @Override
  public void lroStartSucceeded() {
    for (int i = children.size() - 1; i >= 0; i--) {
      children.get(i).lroStartSucceeded();
    }
  }

  @Override
  public void responseReceived() {
    for (int i = children.size() - 1; i >= 0; i--) {
      children.get(i).responseReceived();
    }
  }

  @Override
  public void responseHeadersReceived(Map<String, Object> headers) {
    for (int i = children.size() - 1; i >= 0; i--) {
      children.get(i).responseHeadersReceived(headers);
    }
  }

  @Override
  public void requestSent() {
    for (ApiTracer child : children) {
      child.requestSent();
    }
  }

  @Override
  public void batchRequestSent(long elementCount, long requestSize) {
    for (ApiTracer child : children) {
      child.batchRequestSent(elementCount, requestSize);
    }
  }

  @Override
  public void injectTraceContext(java.util.Map<String, String> carrier) {
    for (ApiTracer child : children) {
      child.injectTraceContext(carrier);
    }
  }

  @Override
  public void requestUrlResolved(String requestUrl) {
    for (ApiTracer child : children) {
      child.requestUrlResolved(requestUrl);
    }
  }
}
