/*
 * Copyright 2021 Google LLC
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

package com.example.speech;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.speech.v1p1beta1.AdaptationClient;
import com.google.cloud.speech.v1p1beta1.CustomClassName;
import com.google.cloud.speech.v1p1beta1.DeleteCustomClassRequest;
import com.google.cloud.speech.v1p1beta1.DeletePhraseSetRequest;
import com.google.cloud.speech.v1p1beta1.PhraseSetName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpeechModelAdaptationBetaTest {
  private static String UNIQUE_ID = UUID.randomUUID().toString();
  private static final String AUDIO_FILE = "gs://cloud-samples-tests/speech/brooklyn.flac";
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String LOCATION = "global";
  private static final String CUSTOM_CLASS_ID = "customClassId" + UNIQUE_ID;
  private static final String PHRASE_SET_ID = "phraseSetId" + UNIQUE_ID;
  private ByteArrayOutputStream bout;
  private PrintStream stdout;
  private PrintStream out;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    stdout = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() throws Exception {
    System.setOut(stdout);
    try (AdaptationClient adaptationClient = AdaptationClient.create()) {
      // clean up resources
      DeleteCustomClassRequest customClassDeleteRequest =
          DeleteCustomClassRequest.newBuilder()
              .setName(CustomClassName.of(PROJECT_ID, LOCATION, CUSTOM_CLASS_ID).toString())
              .build();
      adaptationClient.deleteCustomClass(customClassDeleteRequest);

      // clean up resources
      DeletePhraseSetRequest phraseSetDeleteRequest =
          DeletePhraseSetRequest.newBuilder()
              .setName(PhraseSetName.of(PROJECT_ID, LOCATION, PHRASE_SET_ID).toString())
              .build();
      adaptationClient.deletePhraseSet(phraseSetDeleteRequest);
    }
  }

  @Test
  public void testSpeechModelAdaptationBeta() throws Exception {
    SpeechModelAdaptationBeta.transcribeWithModelAdaptation(
        PROJECT_ID, LOCATION, AUDIO_FILE, CUSTOM_CLASS_ID, PHRASE_SET_ID);
    String got = bout.toString();
    assertThat(got).contains("Adapted Transcription:");
  }
}
