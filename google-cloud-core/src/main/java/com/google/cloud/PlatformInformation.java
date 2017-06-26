/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud;

import com.google.api.core.InternalApi;

@InternalApi("This class should only be used within google-cloud-java")
public final class PlatformInformation {
  public static final String SPECIFICATION_VERSION =
      System.getProperty("java.specification.version");
  public static final String GAE_RUNTIME_VERSION =
      System.getProperty("com.google.appengine.runtime.version");
  public static final String RUNTIME_JETTY_LOGGER =
      System.getProperty("org.eclipse.jetty.util.log.class");
  public static final String JETTY_LOGGER_ON_GAE8_PROD =
      "com.google.apphosting.runtime.jetty9.JettyLogger";
  public static final String JETTY_LOGGER_ON_GAE8_DEVSERVER =
      " com.google.appengine.development.jetty9.JettyLogger"; //note the leading space

  private PlatformInformation() {}

  public static boolean isOnGAE() {
    return GAE_RUNTIME_VERSION != null;
  }

  public static boolean isOnGAEStandard7() {
    //edge case: when a Java 7 GAE app is deployed to DevServer running on J8, SPECIFICATION_VERSION will be "1.8",
    //but RUNTIME_JETTY_LOGGER is unset
    return isOnGAE() && SPECIFICATION_VERSION.equals("1.7")
        || isOnGAE() && RUNTIME_JETTY_LOGGER == null;
  }

  public static boolean isOnGAEStandard8() {
    return isOnGAE()
        && !SPECIFICATION_VERSION.equals("1.7")
        && RUNTIME_JETTY_LOGGER != null
        && (RUNTIME_JETTY_LOGGER.equals(JETTY_LOGGER_ON_GAE8_DEVSERVER)
            || RUNTIME_JETTY_LOGGER.equals(JETTY_LOGGER_ON_GAE8_PROD));
  }
}
