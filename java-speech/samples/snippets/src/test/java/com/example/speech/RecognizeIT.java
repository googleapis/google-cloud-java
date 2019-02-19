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
public class RecognizeIT {
  private static final String BUCKET = "cloud-samples-tests";

  private ByteArrayOutputStream bout;
  private PrintStream out;

  // The path to the audio file to transcribe
  private String audioFileName = "./resources/audio.raw";
  private String multiChannelAudioFileName = "./resources/commercial_stereo.wav";
  private String gcsAudioPath = "gs://" + BUCKET + "/speech/brooklyn.flac";
  private String gcsMultiChannelAudioPath = "gs://" + BUCKET + "/speech/commercial_stereo.wav";

  private String recognitionAudioFile = "./resources/commercial_mono.wav";

  // The path to the video file to transcribe
  private String videoFileName = "./resources/Google_Gnome.wav";
  private String gcsVideoPath = "gs://" + BUCKET + "/speech/Google_Gnome.wav";

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
    Recognize.syncRecognizeFile(audioFileName);
    String got = bout.toString();
    assertThat(got).contains("how old is the Brooklyn Bridge");
  }

  @Test
  public void testRecognizeWordoffset() throws Exception {
    Recognize.syncRecognizeWords(audioFileName);
    String got = bout.toString();
    assertThat(got).contains("how old is the Brooklyn Bridge");
    assertThat(got).contains("\t0.0 sec -");
  }

  @Test
  public void testRecognizeGcs() throws Exception {
    Recognize.syncRecognizeGcs(gcsAudioPath);
    String got = bout.toString();
    assertThat(got).contains("how old is the Brooklyn Bridge");
  }

  @Test
  public void testAsyncRecognizeFile() throws Exception {
    Recognize.asyncRecognizeFile(audioFileName);
    String got = bout.toString();
    assertThat(got).contains("how old is the Brooklyn Bridge");
  }

  @Test
  public void testAsyncRecognizeGcs() throws Exception {
    Recognize.asyncRecognizeGcs(gcsAudioPath);
    String got = bout.toString();
    assertThat(got).contains("how old is the Brooklyn Bridge");
  }

  @Test
  public void testAsyncWordoffset() throws Exception {
    Recognize.asyncRecognizeWords(gcsAudioPath);
    String got = bout.toString();
    assertThat(got).contains("how old is the Brooklyn Bridge");
    assertThat(got).contains("\t0.0 sec -");
  }

  @Test
  public void testStreamRecognize() throws Exception {
    Recognize.streamingRecognizeFile(audioFileName);
    String got = bout.toString();
    assertThat(got).contains("how old is the Brooklyn Bridge");
  }

  @Test
  public void testAutoPunctuation() throws Exception {
    Recognize.transcribeFileWithAutomaticPunctuation(audioFileName);
    String got = bout.toString();
    assertThat(got).contains("How old is the Brooklyn Bridge?");
  }

  @Test
  public void testGcsAutoPunctuation() throws Exception {
    Recognize.transcribeGcsWithAutomaticPunctuation(gcsAudioPath);
    String got = bout.toString();
    assertThat(got).contains("How old is the Brooklyn Bridge?");
  }

  @Test
  public void testStreamAutoPunctuation() throws Exception {
    Recognize.streamingTranscribeWithAutomaticPunctuation(audioFileName);
    String got = bout.toString();
    assertThat(got).contains("How old is the Brooklyn Bridge?");
  }

  @Test
  public void testEnhancedModel() throws Exception {
    Recognize.transcribeFileWithEnhancedModel(recognitionAudioFile);
    String got = bout.toString();
    assertThat(got).contains("Chrome");
  }

  @Test
  public void testModelSelection() throws Exception {
    Recognize.transcribeModelSelection(videoFileName);
    String got = bout.toString();
    assertThat(got).contains("OK Google");
    assertThat(got).contains("the weather outside is sunny");
  }

  @Test
  public void testGcsModelSelection() throws Exception {
    Recognize.transcribeModelSelectionGcs(gcsVideoPath);
    String got = bout.toString();
    assertThat(got).contains("OK Google");
    assertThat(got).contains("the weather outside is sunny");
  }

  @Test
  public void testTranscribeMultiChannel() throws Exception {
    Recognize.transcribeMultiChannel(multiChannelAudioFileName);
    String got = bout.toString();
    assertThat(got).contains("Channel Tag : 1");
  }

  @Test
  public void testTranscribeMultiChannelGcs() throws Exception {
    Recognize.transcribeMultiChannelGcs(gcsMultiChannelAudioPath);
    String got = bout.toString();
    assertThat(got).contains("Channel Tag : 1");
  }
}
