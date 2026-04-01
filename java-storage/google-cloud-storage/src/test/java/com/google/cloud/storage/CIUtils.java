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

package com.google.cloud.storage;

public final class CIUtils {

  private static final String CI_VERBOSE_RUN_KEY = "CI_VERBOSE_RUN";

  private CIUtils() {}

  public static boolean verbose() {
    String ciVerboseRun = System.getenv(CI_VERBOSE_RUN_KEY);
    if (ciVerboseRun == null) {
      ciVerboseRun = System.getProperty(CI_VERBOSE_RUN_KEY);
    }
    return Boolean.parseBoolean(ciVerboseRun);
  }

  public static boolean isRunningInCI() {
    return isJobTypeUnit() || isJobTypeIntegration();
  }

  public static boolean isJobTypeUnit() {
    return isJobTypeEq("test");
  }

  public static boolean isJobTypeIntegration() {
    return isJobTypeEq("integration");
  }

  public static boolean isRunningOnGitHubActions() {
    return System.getenv("GITHUB_JOB") != null;
  }

  private static boolean isJobTypeEq(String integration) {
    return integration.equals(System.getenv("JOB_TYPE"));
  }
}
