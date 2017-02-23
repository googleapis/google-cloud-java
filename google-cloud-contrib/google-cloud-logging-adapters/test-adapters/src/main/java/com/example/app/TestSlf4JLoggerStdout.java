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

package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

public class TestSlf4JLoggerStdout {
  private Logger logger = LoggerFactory.getLogger(TestSlf4jLoggerDirect.class);

  private void print() {
    logger.info("Hello world : INFO");
    logger.info(MarkerFactory.getMarker("NOTICE"), "Hello world : INFO_NOTICE");
    logger.error(MarkerFactory.getMarker("CRITICAL"), "Hello world : Error");
    logger.info(MarkerFactory.getMarker("label1:value1"), "Hello world : labels");
    logger.error("Hello world : {}", "exception", new Throwable("illegal argument"));
    logger.debug("Hello world : DEBUG");
    logger.trace("Hello world : TRACE");
  }

  public static void main(String[] args) {
    System.setProperty(
        "CLOUD_LOGGING_CONFIG", "src/main/resources/google-cloud-logging-stdout.yaml");
    TestSlf4JLoggerStdout testSlf4JLoggerStdout = new TestSlf4JLoggerStdout();
    testSlf4JLoggerStdout.print();
  }
}
