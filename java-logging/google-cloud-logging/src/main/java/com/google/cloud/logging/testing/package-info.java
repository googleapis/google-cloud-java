/*
 * Copyright 2016 Google LLC
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

/**
 * A testing helper for Cloud Logging.
 *
 * <p>A simple usage example:
 *
 * <p>Before the test:
 *
 * <pre>{@code
 * RemoteLoggingHelper helper = RemoteLoggingHelper.create();
 * Logging logging = helper.getOptions().getService();
 * }</pre>
 *
 * <p>Format resource names to avoid name clashes:
 *
 * <pre>{@code
 * String metricName = RemoteLoggingHelper.formatForTest("test-metric");
 * }</pre>
 *
 * @see <a
 *     href="https://github.com/googleapis/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-logging">
 *     Google Cloud Java tools for testing</a>
 */
package com.google.cloud.logging.testing;
