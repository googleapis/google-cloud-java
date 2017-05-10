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

package org.slf4j.impl.logging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.logging.LogEntry;
import java.util.List;

public class StdoutLogging implements ILogging {

  private ObjectMapper objectMapper;

  public StdoutLogging() {
    objectMapper = new ObjectMapper();
  }

  @Override
  public void init() {}

  @Override
  public void write(List<LogEntry> logEntries) {
    try {
      System.out.println(objectMapper.writeValueAsString(logEntries));
    } catch (JsonProcessingException e) {
      System.err.println();
    }
  }
}
