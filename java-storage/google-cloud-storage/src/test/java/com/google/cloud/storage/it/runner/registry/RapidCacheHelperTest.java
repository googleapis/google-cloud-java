/*
 * Copyright 2026 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiExceptionFactory;
import io.grpc.Status;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Test;

public final class RapidCacheHelperTest {

  @Test
  public void isSkippableRapidCacheError_returnsTrueForCapacityAndZoneErrors() {
    Throwable unavailable =
        ApiExceptionFactory.createException(
            "Service unavailable", null, GrpcStatusCode.of(Status.Code.UNAVAILABLE), true);
    Throwable resourceExhausted =
        ApiExceptionFactory.createException(
            "Quota exceeded", null, GrpcStatusCode.of(Status.Code.RESOURCE_EXHAUSTED), false);
    Throwable zoneNotSupported =
        Status.INVALID_ARGUMENT
            .withDescription("Zone us-east1-b does not support rapid-cache-ultra")
            .asRuntimeException();

    assertThat(RapidCacheHelper.isSkippableRapidCacheError(unavailable)).isTrue();
    assertThat(RapidCacheHelper.isSkippableRapidCacheError(resourceExhausted)).isTrue();
    assertThat(RapidCacheHelper.isSkippableRapidCacheError(zoneNotSupported)).isTrue();
  }

  @Test
  public void isSkippableRapidCacheError_returnsFalseForPermissionAndInvalidCacheTypeErrors() {
    Throwable permissionDenied =
        ApiExceptionFactory.createException(
            "Permission denied", null, GrpcStatusCode.of(Status.Code.PERMISSION_DENIED), false);
    Throwable invalidCacheType =
        ApiExceptionFactory.createException(
            "Invalid cache_type: unknown-type",
            null,
            GrpcStatusCode.of(Status.Code.INVALID_ARGUMENT),
            false);

    assertThat(RapidCacheHelper.isSkippableRapidCacheError(permissionDenied)).isFalse();
    assertThat(RapidCacheHelper.isSkippableRapidCacheError(invalidCacheType)).isFalse();
  }

  @Test
  public void createRapidCache_nullControlClient_runsCleanupAndThrows() {
    AtomicBoolean cleanedUp = new AtomicBoolean(false);
    assertThrows(
        IllegalStateException.class,
        () ->
            RapidCacheHelper.createRapidCache(
                null, "test-bucket", "europe-west1-c", () -> cleanedUp.set(true)));
    assertThat(cleanedUp.get()).isTrue();
  }
}
