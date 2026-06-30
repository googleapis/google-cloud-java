/*
 * Copyright 2023 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.auth.oauth2;

import static com.google.auth.oauth2.ExternalAccountCredentials.EXECUTABLE_SOURCE_KEY;

import java.math.BigDecimal;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * Encapsulates the credential source portion of the configuration for PluggableAuthCredentials.
 *
 * <p>Command is the only required field. If timeout_millis is not specified, the library will
 * default to a 30 second timeout.
 *
 * <pre>
 * Sample credential source for Pluggable Auth credentials:
 * {
 *   ...
 *   "credential_source": {
 *     "executable": {
 *       "command": "/path/to/get/credentials.sh --arg1=value1 --arg2=value2",
 *       "timeout_millis": 5000,
 *       "output_file": "/path/to/generated/cached/credentials"
 *     }
 *   }
 * }
 * </pre>
 */
public class PluggableAuthCredentialSource extends ExternalAccountCredentials.CredentialSource {

  // The default timeout for waiting for the executable to finish (30 seconds).
  static final int DEFAULT_EXECUTABLE_TIMEOUT_MS = 30 * 1000;
  // The minimum timeout for waiting for the executable to finish (5 seconds).
  static final int MINIMUM_EXECUTABLE_TIMEOUT_MS = 5 * 1000;
  // The maximum timeout for waiting for the executable to finish (120 seconds).
  static final int MAXIMUM_EXECUTABLE_TIMEOUT_MS = 120 * 1000;

  static final String COMMAND_KEY = "command";
  static final String TIMEOUT_MILLIS_KEY = "timeout_millis";
  static final String OUTPUT_FILE_KEY = "output_file";

  // Required. The command used to retrieve the 3rd party token.
  final String executableCommand;

  // Optional. Set to the default timeout when not provided.
  final int executableTimeoutMs;

  // Optional. Provided when the 3rd party executable caches the response at the specified
  // location.
  @Nullable final String outputFilePath;

  @SuppressWarnings("unchecked")
  public PluggableAuthCredentialSource(Map<String, Object> credentialSourceMap) {
    super(credentialSourceMap);

    if (!credentialSourceMap.containsKey(EXECUTABLE_SOURCE_KEY)) {
      throw new IllegalArgumentException(
          "Invalid credential source for PluggableAuth credentials.");
    }

    Map<String, Object> executable =
        (Map<String, Object>) credentialSourceMap.get(EXECUTABLE_SOURCE_KEY);

    // Command is the only required field.
    if (!executable.containsKey(COMMAND_KEY)) {
      throw new IllegalArgumentException(
          "The PluggableAuthCredentialSource is missing the required 'command' field.");
    }

    // Parse the executable timeout.
    if (executable.containsKey(TIMEOUT_MILLIS_KEY)) {
      Object timeout = executable.get(TIMEOUT_MILLIS_KEY);
      if (timeout instanceof BigDecimal) {
        executableTimeoutMs = ((BigDecimal) timeout).intValue();
      } else if (executable.get(TIMEOUT_MILLIS_KEY) instanceof Integer) {
        executableTimeoutMs = (int) timeout;
      } else {
        executableTimeoutMs = Integer.parseInt((String) timeout);
      }
    } else {
      executableTimeoutMs = DEFAULT_EXECUTABLE_TIMEOUT_MS;
    }

    // Provided timeout must be between 5s and 120s.
    if (executableTimeoutMs < MINIMUM_EXECUTABLE_TIMEOUT_MS
        || executableTimeoutMs > MAXIMUM_EXECUTABLE_TIMEOUT_MS) {
      throw new IllegalArgumentException(
          String.format(
              "The executable timeout must be between %s and %s milliseconds.",
              MINIMUM_EXECUTABLE_TIMEOUT_MS, MAXIMUM_EXECUTABLE_TIMEOUT_MS));
    }

    executableCommand = (String) executable.get(COMMAND_KEY);
    outputFilePath = (String) executable.get(OUTPUT_FILE_KEY);
  }

  String getCommand() {
    return executableCommand;
  }

  int getTimeoutMs() {
    return executableTimeoutMs;
  }

  @Nullable
  String getOutputFilePath() {
    return outputFilePath;
  }
}
