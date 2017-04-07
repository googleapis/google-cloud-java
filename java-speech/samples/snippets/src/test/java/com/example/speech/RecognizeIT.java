/*
  Copyright 2017, Google, Inc.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.example.speech;

import static com.google.common.truth.Truth.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Tests for speech recognize sample.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class RecognizeIT {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String BUCKET = PROJECT_ID;

  private ByteArrayOutputStream bout;
  private PrintStream out;

  // The path to the audio file to transcribe
  private String fileName = "./resources/audio.raw";
  private String gcsPath = "gs://" + BUCKET + "/speech/brooklyn.flac";

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testRecognizeFile() throws Exception {
    Recognize.syncRecognizeFile(fileName);
    String got = bout.toString();
    assertThat(got).contains("how old is the Brooklyn Bridge");
  }

  @Test
  public void testRecognizeGcs() throws Exception {
    Recognize.syncRecognizeGcs(gcsPath);
    String got = bout.toString();
    assertThat(got).contains("how old is the Brooklyn Bridge");
  }

  @Test
  public void testAsyncRecognizeFile() throws Exception {
    Recognize.asyncRecognizeFile(fileName);
    String got = bout.toString();
    assertThat(got).contains("how old is the Brooklyn Bridge");
  }

  @Test
  public void testAsyncRecognizeGcs() throws Exception {
    Recognize.asyncRecognizeGcs(gcsPath);
    String got = bout.toString();
    assertThat(got).contains("how old is the Brooklyn Bridge");
  }

  @Test
  public void testStreamRecognize() throws Exception {
    Recognize.streamingRecognizeFile(fileName);
    String got = bout.toString();
    assertThat(got).contains("how old is the Brooklyn Bridge");
  }
}
