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

import static org.junit.Assume.assumeTrue;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.protobuf.Duration;
import com.google.storage.control.v2.BucketName;
import com.google.storage.control.v2.RapidCache;
import com.google.storage.control.v2.StorageControlClient;
import io.grpc.Status;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Helper for provisioning and disabling Rapid Cache instances on regional test buckets. */
final class RapidCacheHelper {
  private static final Logger LOGGER = LoggerFactory.getLogger(RapidCacheHelper.class);

  private RapidCacheHelper() {}

  static void createRapidCache(
      StorageControlClient ctrl, String bucketName, String targetZone, Runnable cleanupOnFailure) {
    if (ctrl == null) {
      cleanupOnFailure.run();
      throw new IllegalStateException(
          "StorageControlClient is required for REGIONAL_RAPID but was not provided");
    }
    String cacheName =
        String.format(Locale.US, "projects/_/buckets/%s/rapidCaches/%s", bucketName, targetZone);
    RapidCache rapidCache =
        RapidCache.newBuilder()
            .setName(cacheName)
            .setZone(targetZone)
            .setCacheType("rapid-cache-ultra")
            .setTtl(Duration.newBuilder().setSeconds(86400).build()) // 24 hours
            .build();
    try {
      LOGGER.info(
          "Submitting CreateRapidCache LRO for bucket: {} in zone: {}", bucketName, targetZone);
      ctrl.createRapidCacheAsync(BucketName.format("_", bucketName), rapidCache)
          .get(30, TimeUnit.SECONDS);
      LOGGER.info("Successfully created Rapid Cache in zone: {}", targetZone);
    } catch (TimeoutException te) {
      LOGGER.warn("CreateRapidCache LRO timed out after 30s. Skipping test.");
      cleanupOnFailure.run();
      assumeTrue(
          "Skipping test because Rapid Cache creation LRO timed out (30s) in zone: " + targetZone,
          false);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      cleanupOnFailure.run();
      throw new RuntimeException(
          "Interrupted while waiting for CreateRapidCache LRO in zone: " + targetZone, ie);
    } catch (ExecutionException | RuntimeException e) {
      Throwable cause = e instanceof ExecutionException && e.getCause() != null ? e.getCause() : e;
      cleanupOnFailure.run();
      if (isSkippableRapidCacheError(cause)) {
        LOGGER.warn(
            "CreateRapidCache LRO unavailable in zone {}: {}. Skipping test.",
            targetZone,
            cause.getMessage());
        assumeTrue(
            "Skipping test due to Rapid Cache capacity/availability in zone "
                + targetZone
                + ": "
                + cause.getMessage(),
            false);
      }
      if (cause instanceof RuntimeException) {
        throw (RuntimeException) cause;
      }
      throw new RuntimeException("CreateRapidCache LRO failed in zone: " + targetZone, cause);
    }
  }

  static void disableRapidCache(StorageControlClient ctrl, String bucketName, String targetZone) {
    if (ctrl == null || targetZone == null) {
      return;
    }
    String cacheName =
        String.format(Locale.US, "projects/_/buckets/%s/rapidCaches/%s", bucketName, targetZone);
    try {
      ctrl.disableRapidCacheAsync(cacheName).get(30, TimeUnit.SECONDS);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
      LOGGER.warn("Interrupted while cleaning up rapid cache: {}", ie.getMessage());
    } catch (Exception e) {
      LOGGER.warn("Failed to clean up rapid cache: {}", e.getMessage());
    }
  }

  static boolean isSkippableRapidCacheError(Throwable cause) {
    if (cause instanceof ApiException) {
      StatusCode.Code code = ((ApiException) cause).getStatusCode().getCode();
      if (code == StatusCode.Code.UNAVAILABLE || code == StatusCode.Code.RESOURCE_EXHAUSTED) {
        return true;
      }
    }
    Status status = Status.fromThrowable(cause);
    if (status.getCode() == Status.Code.UNAVAILABLE
        || status.getCode() == Status.Code.RESOURCE_EXHAUSTED) {
      return true;
    }
    String msg = cause.getMessage();
    if (msg != null) {
      String lower = msg.toLowerCase(Locale.US);
      if (lower.contains("zone")
          && (lower.contains("not support")
              || lower.contains("not a valid zone")
              || lower.contains("unavailable")
              || lower.contains("not enabled"))) {
        return true;
      }
    }
    return false;
  }
}
