/*
 * Copyright 2019 Google Inc.
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for SsmlAddresses sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class SsmlAddressesIT {

  private static String OUTPUT = "output.mp3";
  private static String TEXT_FILE = "resources/example.txt";
  private static String SSML_FILE = "resources/example.ssml";

  private ByteArrayOutputStream bout;
  private PrintStream out;
  private File outputFile;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @Test
  public void testTextToSsml() throws Exception {
    // Act
    String ssml = SsmlAddresses.textToSsml(TEXT_FILE);
    String expectedSsml = new String(Files.readAllBytes(Paths.get(SSML_FILE)));

    // Assert
    assertThat(ssml).contains(expectedSsml);
  }

  @Test
  public void testSsmlToAudio() throws Exception {
    // Act
    String ssml = new String(Files.readAllBytes(Paths.get(SSML_FILE)));
    SsmlAddresses.ssmlToAudio(ssml, OUTPUT);

    // Assert
    outputFile = new File(OUTPUT);
    assertThat(outputFile.isFile()).isTrue();
    String got = bout.toString();
    assertThat(got).contains("Audio content written to file output.mp3");

    // After
    outputFile.delete();
  }
}
