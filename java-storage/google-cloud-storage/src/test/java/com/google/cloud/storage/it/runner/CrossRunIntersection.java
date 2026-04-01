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

package com.google.cloud.storage.it.runner;

import static java.util.Objects.requireNonNull;

import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import java.util.Locale;
import java.util.Objects;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents a single cell in the computed cross product specified by a {@link CrossRun}
 * declaration
 */
@ThreadSafe
@Immutable
public final class CrossRunIntersection {

  private final @Nullable Backend backend;
  private final @Nullable Transport transport;

  private CrossRunIntersection(@Nullable Backend backend, @Nullable Transport transport) {
    this.backend = backend;
    this.transport = transport;
  }

  @Nullable
  public Backend getBackend() {
    return backend;
  }

  @Nullable
  public Transport getTransport() {
    return transport;
  }

  public CrossRunIntersection clearBackend() {
    if (backend == null) {
      return this;
    } else {
      return new CrossRunIntersection(null, transport);
    }
  }

  public CrossRunIntersection clearTransport() {
    if (transport == null) {
      return this;
    } else {
      return new CrossRunIntersection(backend, null);
    }
  }

  public CrossRunIntersection withBackend(Backend backend) {
    requireNonNull(backend, "backend must be non null");
    if (this.backend == backend) {
      return this;
    } else {
      return new CrossRunIntersection(backend, transport);
    }
  }

  public CrossRunIntersection withTransport(Transport transport) {
    requireNonNull(transport, "transport must be non null");
    if (this.transport == transport) {
      return this;
    } else {
      return new CrossRunIntersection(backend, transport);
    }
  }

  public boolean anyMatch(CrossRunIntersection other) {
    CrossRunIntersection l = this;
    CrossRunIntersection r = other;

    if (l.backend == null) {
      r = r.clearBackend();
    }
    if (r.backend == null) {
      l = l.clearBackend();
    }

    if (l.transport == null) {
      r = r.clearTransport();
    }
    if (r.transport == null) {
      l = l.clearTransport();
    }

    return l.equals(r);
  }

  /**
   * use Square brackets to bound our changing of the test name it appears intellij has custom
   * handling to drop the square bracketed text which results in it being able to resolve and link
   * the test method. The use of square brackets follows the pattern set forth by @Parameterized
   * from JUnit, and resembles index based access of an array.
   */
  public String fmtSuiteName() {
    String t = transport != null ? transport.toString() : "NULL_TRANSPORT";
    String b = backend != null ? backend.toString() : "NULL_BACKEND";
    return String.format(Locale.US, "[%s][%s]", t, b);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CrossRunIntersection)) {
      return false;
    }
    CrossRunIntersection crossRunIntersection = (CrossRunIntersection) o;
    return backend == crossRunIntersection.backend && transport == crossRunIntersection.transport;
  }

  @Override
  public int hashCode() {
    return Objects.hash(backend, transport);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("backend", backend)
        .add("transport", transport)
        .toString();
  }

  public static CrossRunIntersection of(@Nullable Backend t, @Nullable Transport s) {
    return new CrossRunIntersection(t, s);
  }

  public static ImmutableSet<CrossRunIntersection> expand(CrossRun.Ignore i) {
    ImmutableSet<Backend> backends = ImmutableSet.copyOf(i.backends());
    ImmutableSet<Transport> transports = ImmutableSet.copyOf(i.transports());
    return expand(backends, transports);
  }

  public static ImmutableSet<CrossRunIntersection> expand(CrossRun.Exclude i) {
    ImmutableSet<Backend> backends = ImmutableSet.copyOf(i.backends());
    ImmutableSet<Transport> transports = ImmutableSet.copyOf(i.transports());
    return expand(backends, transports);
  }

  public static ImmutableSet<CrossRunIntersection> expand(
      ImmutableSet<Backend> backends, ImmutableSet<@Nullable Transport> transports) {
    if (backends.isEmpty() && transports.isEmpty()) {
      return ImmutableSet.of();
    } else if (!backends.isEmpty() && !transports.isEmpty()) {
      return backends.stream()
          .flatMap(t -> transports.stream().map(s -> new CrossRunIntersection(t, s)))
          .collect(ImmutableSet.toImmutableSet());
    } else if (!backends.isEmpty()) {
      return backends.stream()
          .map(t -> new CrossRunIntersection(t, null))
          .collect(ImmutableSet.toImmutableSet());
    } else {
      return transports.stream()
          .map(s -> new CrossRunIntersection(null, s))
          .collect(ImmutableSet.toImmutableSet());
    }
  }
}
