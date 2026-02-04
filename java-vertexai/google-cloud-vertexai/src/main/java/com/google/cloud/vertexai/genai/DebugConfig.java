/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.vertexai.genai;

/** Data class configuration for debugging or testing the Client. */
@ExcludeFromGeneratedCoverageReport
final class DebugConfig {
  private final String clientMode;
  private final String replayId;
  private final String replaysDirectory;

  DebugConfig() {
    String clientMode = System.getenv("GOOGLE_GENAI_CLIENT_MODE");
    this.clientMode = clientMode != null ? clientMode : "";

    String replayId = System.getenv("GOOGLE_GENAI_REPLAY_ID");
    this.replayId = replayId != null ? replayId : "";

    String replaysDirectory = System.getenv("GOOGLE_GENAI_REPLAYS_DIRECTORY");
    this.replaysDirectory = replaysDirectory != null ? replaysDirectory : "";
  }

  DebugConfig(String clientMode, String replayId, String replaysDirectory) {
    String envClientMode = System.getenv("GOOGLE_GENAI_CLIENT_MODE");
    this.clientMode =
        clientMode != null ? clientMode : (envClientMode != null ? envClientMode : "");

    String envReplayId = System.getenv("GOOGLE_GENAI_REPLAY_ID");
    this.replayId = replayId != null ? replayId : (envReplayId != null ? envReplayId : "");

    String envReplaysDirectory = System.getenv("GOOGLE_GENAI_REPLAYS_DIRECTORY");
    this.replaysDirectory =
        replaysDirectory != null
            ? replaysDirectory
            : (envReplaysDirectory != null ? envReplaysDirectory : "");
  }

  public String clientMode() {
    return this.clientMode;
  }

  public String replayId() {
    return this.replayId;
  }

  public String replaysDirectory() {
    return this.replaysDirectory;
  }
}
