/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.spanner;

import static com.google.cloud.spanner.IntegrationTestEnv.isRetryableResourceExhaustedException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class IntegrationTestEnvTest {

  @Test
  public void testIsRetryableResourceExhaustedException() {
    assertFalse(
        isRetryableResourceExhaustedException(
            SpannerExceptionFactory.newSpannerException(ErrorCode.INVALID_ARGUMENT, "test")));
    assertFalse(
        isRetryableResourceExhaustedException(
            SpannerExceptionFactory.newSpannerException(ErrorCode.RESOURCE_EXHAUSTED, "test")));
    assertTrue(
        isRetryableResourceExhaustedException(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.RESOURCE_EXHAUSTED,
                "Operation with name"
                    + " \"projects/my-project/instances/my-instance/operations/32bb3dccf4243afc\""
                    + " failed with status = GrpcStatusCode{transportCode=RESOURCE_EXHAUSTED} and"
                    + " message = Project 123 cannot add 1 nodes in region .")));
    assertTrue(
        isRetryableResourceExhaustedException(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.RESOURCE_EXHAUSTED,
                "Operation with name"
                    + " \"projects/my-project/instances/my-instance/operations/32bb3dccf4243afc\""
                    + " failed with status = GrpcStatusCode{transportCode=RESOURCE_EXHAUSTED} and"
                    + " message = Project 123 cannot add 99 nodes in region .")));
    assertTrue(
        isRetryableResourceExhaustedException(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.RESOURCE_EXHAUSTED,
                "Could not create instance. Quota exceeded for quota metric 'Instance create"
                    + " requests' and limit 'Instance create requests per minute'")));
  }
}
