/*
 * Copyright 2018 Google Inc.
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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for speech recognize sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class RecognizeBetaIT {
  private static final String BUCKET = "cloud-samples-data";

  private ByteArrayOutputStream bout;
  private PrintStream out;

  // The path to the audio file to transcribe
  private String audioFileName = "./resources/audio.raw";
  private String multiChannelAudioFileName = "./resources/commercial_stereo.wav";
  private String gcsMultiChannelAudioPath = "gs://" + BUCKET + "/speech/commercial_stereo.wav";
  private String gcsAudioPath = "gs://" + BUCKET + "/speech/brooklyn_bridge.flac";
  private String gcsDiarizationAudioPath = "gs://" + BUCKET + "/speech/commercial_mono.wav";

  // The path to the video file to transcribe
  private String videoFileName = "./resources/Google_Gnome.wav";
  private String gcsVideoPath = "gs://" + BUCKET + "/speech/Google_Gnome.wav";

  private String recognitionAudioFile = "./resources/commercial_mono.wav";

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
  public void testMetadata() throws Exception {
    RecognizeBeta.transcribeFileWithMetadata(recognitionAudioFile);
    String got = bout.toString();
    assertThat(got).contains("Chrome");
  }

  @Test
  public void testTranscribeDiarization() throws Exception {
    RecognizeBeta.transcribeDiarization(recognitionAudioFile);
    String got = bout.toString();
    // Diarization (a beta product) can be flaky, therefore this test is only looking for output
    assertThat(got).contains("Speaker");
  }

  @Test
  public void testTranscribeDiarizationGcs() throws Exception {
    RecognizeBeta.transcribeDiarizationGcs(gcsDiarizationAudioPath);
    String got = bout.toString();
    // Diarization (a beta product) can be flaky, therefore this test is only looking for output
    assertThat(got).contains("Speaker");
  }

  @Test
  public void testTranscribeMultiChannel() throws Exception {
    RecognizeBeta.transcribeMultiChannel(multiChannelAudioFileName);
    String got = bout.toString();
    assertThat(got).contains("Channel Tag : 1");
  }

  @Test
  public void testTranscribeMultiChannelGcs() throws Exception {
    RecognizeBeta.transcribeMultiChannelGcs(gcsMultiChannelAudioPath);
    String got = bout.toString();
    assertThat(got).contains("Channel Tag : 1");
  }

  @Test
  public void testTranscribeMultiLanguage() throws Exception {
    RecognizeBeta.transcribeMultiLanguage(videoFileName);
    String got = bout.toString();
    assertThat(got).contains("Transcript : OK Google");
  }

  @Test
  public void testTranscribeMultiLanguageGcs() throws Exception {
    RecognizeBeta.transcribeMultiLanguageGcs(gcsVideoPath);
    String got = bout.toString();
    assertThat(got).contains("Transcript : OK Google");
  }

  @Test
  public void testTranscribeWordLevelConfidence() throws Exception {
    RecognizeBeta.transcribeWordLevelConfidence(audioFileName);
    String got = bout.toString();
    assertThat(got).contains("Transcript : how old is the Brooklyn Bridge");
    assertThat(got).contains("First Word and Confidence : how");
  }

  @Test
  public void testTranscribeWordLevelConfidenceGcs() throws Exception {
    RecognizeBeta.transcribeWordLevelConfidenceGcs(gcsAudioPath);
    String got = bout.toString();
    assertThat(got).contains("Transcript : how old is the Brooklyn Bridge");
    assertThat(got).contains("First Word and Confidence : how");
  }
}
