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

/**
 * A composite implementation of {@link ApiTracer} that delegates all tracing events to a list of
 * underlying tracers.
 *
 * <p>For internal use only.
 */
@InternalApi
class CompositeTracer extends BaseApiTracer {
  private final List<ApiTracer> children;

  public CompositeTracer(List<ApiTracer> children) {
    this.children = ImmutableList.copyOf(children);
  }

  @Override
  public Scope inScope() {
    final List<Scope> childScopes = new ArrayList<>(children.size());

    try {
      for (ApiTracer child : children) {
        childScopes.add(child.inScope());
      }
    } catch (RuntimeException e) {
      for (int i = childScopes.size() - 1; i >= 0; i--) {
        try {
          childScopes.get(i).close();
        } catch (RuntimeException suppressed) {
          e.addSuppressed(suppressed);
        }
      }
      throw e;
    }

    return () -> {
      RuntimeException exception = null;
      for (int i = childScopes.size() - 1; i >= 0; i--) {
        try {
          childScopes.get(i).close();
        } catch (RuntimeException e) {
          if (exception == null) {
            exception = e;
          } else {
            exception.addSuppressed(e);
          }
        }
      }
      if (exception != null) {
        throw exception;
      }
    };
  }

  @Override
  public void operationSucceeded() {
    for (int i = children.size() - 1; i >= 0; i--) {
      children.get(i).operationSucceeded();
    }
  }

  @Override
  public void operationCancelled() {
    for (int i = children.size() - 1; i >= 0; i--) {
      children.get(i).operationCancelled();
    }
  }

  @Override
  public void operationFailed(Throwable error) {
    for (int i = children.size() - 1; i >= 0; i--) {
      children.get(i).operationFailed(error);
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
    for (int i = children.size() - 1; i >= 0; i--) {
      children.get(i).attemptSucceeded();
    }
  }

  @Override
  public void attemptCancelled() {
    for (int i = children.size() - 1; i >= 0; i--) {
      children.get(i).attemptCancelled();
    }
  }

  @Override
  public void attemptFailed(Throwable error, org.threeten.bp.Duration delay) {
    for (int i = children.size() - 1; i >= 0; i--) {
      children.get(i).attemptFailed(error, delay);
    }
  }

  @Override
  public void attemptFailedDuration(Throwable error, java.time.Duration delay) {
    for (int i = children.size() - 1; i >= 0; i--) {
      children.get(i).attemptFailedDuration(error, delay);
    }
  }

  @Override
  public void attemptFailedRetriesExhausted(Throwable error) {
    for (int i = children.size() - 1; i >= 0; i--) {
      children.get(i).attemptFailedRetriesExhausted(error);
    }
  }

  @Override
  public void attemptPermanentFailure(Throwable error) {
    for (int i = children.size() - 1; i >= 0; i--) {
      children.get(i).attemptPermanentFailure(error);
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
}
