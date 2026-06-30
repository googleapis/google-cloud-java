/*
 * Copyright 2017, Google Inc.
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
 *     * Neither the name of Google Inc. nor the names of its
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
package com.google.api.core;

import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.Service;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Base class for {@link ApiService}. Similar to Guava's {@code AbstractService} but redeclared so
 * that Guava can be shaded.
 */
public abstract class AbstractApiService implements ApiService {
  private static final ImmutableMap<Service.State, ApiService.State> GUAVA_TO_API_SERVICE_STATE =
      ImmutableMap.<Service.State, ApiService.State>builder()
          .put(Service.State.FAILED, ApiService.State.FAILED)
          .put(Service.State.NEW, ApiService.State.NEW)
          .put(Service.State.RUNNING, ApiService.State.RUNNING)
          .put(Service.State.STARTING, ApiService.State.STARTING)
          .put(Service.State.STOPPING, ApiService.State.STOPPING)
          .put(Service.State.TERMINATED, ApiService.State.TERMINATED)
          .build();

  private final InnerService impl = new InnerService();

  protected AbstractApiService() {}

  protected abstract void doStart();

  protected abstract void doStop();

  @Override
  public void addListener(final ApiService.Listener listener, Executor executor) {
    impl.addListener(
        new Service.Listener() {
          @Override
          public void failed(Service.State from, Throwable failure) {
            listener.failed(GUAVA_TO_API_SERVICE_STATE.get(from), failure);
          }

          @Override
          public void running() {
            listener.running();
          }

          @Override
          public void starting() {
            listener.starting();
          }

          @Override
          public void stopping(Service.State from) {
            listener.stopping(GUAVA_TO_API_SERVICE_STATE.get(from));
          }

          @Override
          public void terminated(Service.State from) {
            listener.terminated(GUAVA_TO_API_SERVICE_STATE.get(from));
          }
        },
        executor);
  }

  public void awaitRunning() {
    impl.awaitRunning();
  }

  public void awaitRunning(long timeout, TimeUnit unit) throws TimeoutException {
    impl.awaitRunning(timeout, unit);
  }

  public void awaitTerminated() {
    impl.awaitTerminated();
  }

  public void awaitTerminated(long timeout, TimeUnit unit) throws TimeoutException {
    impl.awaitTerminated(timeout, unit);
  }

  public Throwable failureCause() {
    return impl.failureCause();
  }

  public boolean isRunning() {
    return impl.isRunning();
  }

  public ApiService startAsync() {
    impl.startAsync();
    return this;
  }

  public State state() {
    return GUAVA_TO_API_SERVICE_STATE.get(impl.state());
  }

  public ApiService stopAsync() {
    impl.stopAsync();
    return this;
  }

  protected void notifyStarted() {
    impl.innerNotifyStarted();
  }

  protected void notifyStopped() {
    impl.innerNotifyStopped();
  }

  protected void notifyFailed(Throwable cause) {
    impl.innerNotifyFailed(cause);
  }

  private class InnerService extends AbstractService {
    @Override
    protected void doStart() {
      AbstractApiService.this.doStart();
    }

    @Override
    protected void doStop() {
      AbstractApiService.this.doStop();
    }

    private void innerNotifyStarted() {
      notifyStarted();
    }

    private void innerNotifyStopped() {
      notifyStopped();
    }

    private void innerNotifyFailed(Throwable cause) {
      notifyFailed(cause);
    }
  }
}
