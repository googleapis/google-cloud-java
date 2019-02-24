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

package com.example.texttospeech;

import static com.google.common.truth.Truth.assertThat;

import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.File;

import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for SynthesizeText sample.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class SynthesizeTextIT {

  private static String OUTPUT = "output.mp3";
  private static String TEXT = "Hello there.";
  private static String SSML = "<speak>Hello there.</speak>";
  private static String EFFECTSPROFILE = "telephony-class-application";

  private ByteArrayOutputStream bout;
  private PrintStream out;
  private File outputFile;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    outputFile.delete();
  }

  @Test
  public void testSynthesizeText() throws Exception {
    // Act
    ByteString audioContents = SynthesizeText.synthesizeText(TEXT);

    // Assert
    assertThat(audioContents.isEmpty()).isFalse();
    outputFile = new File(OUTPUT);
    assertThat(outputFile.isFile()).isTrue();
    String got = bout.toString();
    assertThat(got).contains("Audio content written to file \"output.mp3\"");
  }

  @Test
  public void testSynthesizeSsml() throws Exception {
    // Act
    ByteString audioContents = SynthesizeText.synthesizeSsml(SSML);

    // Assert
    assertThat(audioContents.isEmpty()).isFalse();
    outputFile = new File(OUTPUT);
    assertThat(outputFile.isFile()).isTrue();
    String got = bout.toString();
    assertThat(got).contains("Audio content written to file \"output.mp3\"");
  }

  @Test
  public void testSynthesizeTextWithAudioProfile() throws Exception {
    // Act
    ByteString audioContents = SynthesizeText.synthesizeTextWithAudioProfile(TEXT, EFFECTSPROFILE);

    // Assert
    assertThat(audioContents.isEmpty()).isFalse();
    outputFile = new File(OUTPUT);
    assertThat(outputFile.isFile()).isTrue();
    String got = bout.toString();
    assertThat(got).contains("Audio content written to file \"output.mp3\"");
  }
}