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

import com.google.cloud.texttospeech.v1.Voice;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for ListAllSupportedVoices sample.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class ListAllSupportedVoicesIT {

  private ByteArrayOutputStream bout;
  private PrintStream out;
  private ListAllSupportedVoices listAllSupportedVoices;


  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    listAllSupportedVoices = new ListAllSupportedVoices();
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testListAllSupportedVoices() throws Exception {
    // Act
    List<Voice> voices = listAllSupportedVoices.listAllSupportedVoices();

    // Assert
    assertThat(voices.isEmpty()).isFalse();
    String got = bout.toString();
    assertThat(got).contains("en-US");
    assertThat(got).contains("SSML Voice Gender: MALE");
    assertThat(got).contains("SSML Voice Gender: FEMALE");
  }
}