/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.logging.jul;

// [START logging_jul_quickstart]

import java.util.logging.Logger;

public class Quickstart {
  private static final Logger logger = Logger.getLogger(Quickstart.class.getName());

  public static void main(String[] args) {
    logger.info("Logging INFO with java.util.logging");
    logger.severe("Logging ERROR with java.util.logging");
  }
}
// [END logging_jul_quickstart]
