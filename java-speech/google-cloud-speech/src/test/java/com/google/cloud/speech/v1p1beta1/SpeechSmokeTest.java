/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.speech.v1p1beta1;

import com.google.common.base.Preconditions;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assume;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class SpeechSmokeTest {
  private static final String PROJECT_ENV_NAME = "GOOGLE_CLOUD_PROJECT";
  private static final String LEGACY_PROJECT_ENV_NAME = "GCLOUD_PROJECT";

  @Test
  public void run() {
    // Skip smoke tests if running in VPCSC because our V1 integration tests
    // cover VPC-SC.
    Assume.assumeTrue(System.getenv("GOOGLE_CLOUD_TESTS_IN_VPCSC") == null);
    main(null);
  }

  public static void main(String args[]) {
    Logger.getLogger("").setLevel(Level.WARNING);
    try {
      executeNoCatch();
      System.out.println("OK");
    } catch (Exception e) {
      System.err.println("Failed with exception:");
      e.printStackTrace(System.err);
      System.exit(1);
    }
  }

  public static void executeNoCatch() throws Exception {
    try (SpeechClient client = SpeechClient.create()) {
      String languageCode = "en-US";
      int sampleRateHertz = 44100;
      RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.FLAC;
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setLanguageCode(languageCode)
              .setSampleRateHertz(sampleRateHertz)
              .setEncoding(encoding)
              .build();
      String uri = "gs://cloud-samples-data/speech/brooklyn_bridge.flac";
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(uri).build();

      RecognizeResponse response = client.recognize(config, audio);
    }
  }

  private static String getProjectId() {
    String projectId = System.getProperty(PROJECT_ENV_NAME, System.getenv(PROJECT_ENV_NAME));
    if (projectId == null) {
      projectId =
          System.getProperty(LEGACY_PROJECT_ENV_NAME, System.getenv(LEGACY_PROJECT_ENV_NAME));
    }
    Preconditions.checkArgument(projectId != null, "A project ID is required.");
    return projectId;
  }
}
