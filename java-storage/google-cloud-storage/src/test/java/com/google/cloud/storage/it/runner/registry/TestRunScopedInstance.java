/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage.it.runner.registry;

import com.google.common.base.MoreObjects;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import java.util.function.Supplier;
import org.junit.runner.notification.RunListener.ThreadSafe;

/**
 * Thread safe shim to manage the initialization and lifecycle of a specific instance of a {@link
 * com.google.cloud.storage.it.runner.registry.ManagedLifecycle} instance.
 */
@ThreadSafe
public final class TestRunScopedInstance<T extends ManagedLifecycle> implements Supplier<T> {

  private final String name;
  private final Supplier<T> ctor;
  private volatile T instance;

  private TestRunScopedInstance(String name, Supplier<T> ctor) {
    this.name = name;
    this.ctor = ctor;
  }

  static <T extends ManagedLifecycle> TestRunScopedInstance<T> of(String name, Supplier<T> ctor) {
    return new TestRunScopedInstance<>(name, ctor);
  }

  public String getName() {
    return name;
  }

  public T get() {
    if (instance == null) {
      synchronized (this) {
        if (instance == null) {
          // if we don't short-circuit for OTEL_SDK we will cause a stack overflow, because we would
          // be trying to get our instance to record that we're starting our instance.
          if (name.equals("fixture/OTEL_SDK")) {
            T tmp = ctor.get();
            tmp.start();
            instance = tmp;
          } else {
            Span span =
                Registry.getInstance()
                    .otelSdk
                    .get()
                    .get()
                    .getTracer("test")
                    .spanBuilder("registry/" + name + "/start")
                    .setAttribute("service.name", "registry")
                    .startSpan();
            try (Scope ignore = span.makeCurrent()) {
              T tmp = ctor.get();
              tmp.start();
              instance = tmp;
            } catch (Throwable t) {
              span.recordException(t);
              span.setStatus(StatusCode.ERROR, t.getClass().getSimpleName());
              throw t;
            } finally {
              span.end();
            }
          }
        }
      }
    }
    return instance;
  }

  public void shutdown() throws Exception {
    T tmp = instance;
    if (tmp != null) {
      synchronized (this) {
        instance = null;
      }
      if (name.equals("OTEL_SDK")) {
        tmp.stop();
      } else {
        Span span =
            Registry.getInstance()
                .otelSdk
                .get()
                .get()
                .getTracer("test")
                .spanBuilder("registry/" + name + "/stop")
                .setAttribute("service.name", "registry")
                .startSpan();
        try (Scope ignore = span.makeCurrent()) {
          tmp.stop();
        } catch (Throwable t) {
          span.recordException(t);
          span.setStatus(StatusCode.ERROR, t.getClass().getSimpleName());
          throw t;
        } finally {
          span.end();
        }
      }
    }
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .add("ctor", ctor)
        .add("instance", instance)
        .toString();
  }
}
