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
import com.google.cloud.storage.it.runner.annotations.LocationType;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import java.util.Collections;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
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
  private final @Nullable LocationType locationType;

  private CrossRunIntersection(
      @Nullable Backend backend,
      @Nullable Transport transport,
      @Nullable LocationType locationType) {
    this.backend = backend;
    this.transport = transport;
    this.locationType = locationType;
  }

  @Nullable
  public Backend getBackend() {
    return backend;
  }

  @Nullable
  public Transport getTransport() {
    return transport;
  }

  @Nullable
  public LocationType getLocationType() {
    return locationType;
  }

  public CrossRunIntersection clearBackend() {
    if (backend == null) {
      return this;
    } else {
      return new CrossRunIntersection(null, transport, locationType);
    }
  }

  public CrossRunIntersection clearTransport() {
    if (transport == null) {
      return this;
    } else {
      return new CrossRunIntersection(backend, null, locationType);
    }
  }

  public CrossRunIntersection clearLocationType() {
    if (locationType == null) {
      return this;
    } else {
      return new CrossRunIntersection(backend, transport, null);
    }
  }

  public CrossRunIntersection withBackend(Backend backend) {
    requireNonNull(backend, "backend must be non null");
    if (this.backend == backend) {
      return this;
    } else {
      return new CrossRunIntersection(backend, transport, locationType);
    }
  }

  public CrossRunIntersection withTransport(Transport transport) {
    requireNonNull(transport, "transport must be non null");
    if (this.transport == transport) {
      return this;
    } else {
      return new CrossRunIntersection(backend, transport, locationType);
    }
  }

  public CrossRunIntersection withLocationType(LocationType locationType) {
    requireNonNull(locationType, "locationType must be non null");
    if (this.locationType == locationType) {
      return this;
    } else {
      return new CrossRunIntersection(backend, transport, locationType);
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

    if (l.locationType == null) {
      r = r.clearLocationType();
    }
    if (r.locationType == null) {
      l = l.clearLocationType();
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
    String lt = locationType != null ? locationType.toString() : "NULL_LOCATION";
    return String.format(Locale.US, "[%s][%s][%s]", t, b, lt);
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
    return backend == crossRunIntersection.backend
        && transport == crossRunIntersection.transport
        && locationType == crossRunIntersection.locationType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(backend, transport, locationType);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("backend", backend)
        .add("transport", transport)
        .add("locationType", locationType)
        .toString();
  }

  public static CrossRunIntersection of(@Nullable Backend b, @Nullable Transport t) {
    return new CrossRunIntersection(b, t, null);
  }

  public static CrossRunIntersection of(
      @Nullable Backend b, @Nullable Transport t, @Nullable LocationType lt) {
    return new CrossRunIntersection(b, t, lt);
  }

  public static ImmutableSet<CrossRunIntersection> expand(CrossRun.Ignore i) {
    ImmutableSet<Backend> backends = ImmutableSet.copyOf(i.backends());
    ImmutableSet<Transport> transports = ImmutableSet.copyOf(i.transports());
    ImmutableSet<LocationType> locations = ImmutableSet.copyOf(i.locations());
    return expand(backends, transports, locations);
  }

  public static ImmutableSet<CrossRunIntersection> expand(CrossRun.Exclude i) {
    ImmutableSet<Backend> backends = ImmutableSet.copyOf(i.backends());
    ImmutableSet<Transport> transports = ImmutableSet.copyOf(i.transports());
    ImmutableSet<LocationType> locations = ImmutableSet.copyOf(i.locations());
    return expand(backends, transports, locations);
  }

  public static ImmutableSet<CrossRunIntersection> expand(
      ImmutableSet<Backend> backends,
      ImmutableSet<@Nullable Transport> transports,
      ImmutableSet<@Nullable LocationType> locations) {
    if (backends.isEmpty() && transports.isEmpty() && locations.isEmpty()) {
      return ImmutableSet.of();
    }

    Set<@Nullable Backend> bSet =
        backends.isEmpty() ? Collections.singleton((Backend) null) : backends;
    Set<@Nullable Transport> tSet =
        transports.isEmpty() ? Collections.singleton((Transport) null) : transports;
    Set<@Nullable LocationType> lSet =
        locations.isEmpty() ? Collections.singleton((LocationType) null) : locations;

    return bSet.stream()
        .flatMap(
            b ->
                tSet.stream()
                    .flatMap(t -> lSet.stream().map(l -> new CrossRunIntersection(b, t, l))))
        .filter(i -> !(i.backend == null && i.transport == null && i.locationType == null))
        .collect(ImmutableSet.toImmutableSet());
  }
}
