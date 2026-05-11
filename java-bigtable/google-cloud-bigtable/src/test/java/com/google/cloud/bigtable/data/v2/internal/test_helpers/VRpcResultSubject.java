/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.internal.test_helpers;

import static com.google.common.truth.Truth.assertAbout;

import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.common.truth.ComparableSubject;
import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import com.google.rpc.RetryInfo;
import java.time.Duration;
import java.util.Optional;
import javax.annotation.Nullable;

public final class VRpcResultSubject extends Subject {
  private final @Nullable VRpcResult actual;

  private VRpcResultSubject(FailureMetadata failureMetadata, @Nullable VRpcResult subject) {
    super(failureMetadata, subject);
    this.actual = subject;
  }

  public Subject state() {
    return check("state").that(actual.getState());
  }

  public Subject rejected() {
    return check("rejected").that(actual.getRejected());
  }

  public void hasRetryInfo() {
    check("retryInfo").that(actual.getRetryInfo()).isNotNull();
  }

  public ComparableSubject<Duration> retryInfoDelay() {
    return check("retryInfo.delay")
        .that(
            Optional.ofNullable(actual.getRetryInfo())
                .map(RetryInfo::getRetryDelay)
                .map(d -> Duration.ofSeconds(d.getSeconds()).plus(Duration.ofNanos(d.getNanos())))
                .orElse(null));
  }

  public ComparableSubject<Duration> backendLatency() {
    return check("retryInfo.backendLatency").that(actual.getBackendLatency());
  }

  public void isOk() {
    status().isOk();
  }

  public StatusSubject status() {
    return check("status").about(StatusSubject.statuses()).that(actual.getStatus());
  }

  public static VRpcResultSubject assertThat(@Nullable VRpcResult vRpcResult) {
    return assertAbout(vrpcResults()).that(vRpcResult);
  }

  public static Factory<VRpcResultSubject, VRpcResult> vrpcResults() {
    return VRpcResultSubject::new;
  }
}
