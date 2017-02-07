/*
 * Copyright (c) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example;

import static com.google.common.truth.Truth.assertThat;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Integration (system) tests for {@link Quickstart}.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class QuickstartIT {

  private ByteArrayOutputStream bout;
  private PrintStream out;

  @BeforeClass
  public static void setUpClass() throws Exception {
    SnippetsIT.setUpClass();
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    System.setOut(out);
  }

  /**
   * Destroys all the keys created during this test run.
   */
  @AfterClass
  public static void tearDownClass() throws Exception {
    SnippetsIT.tearDownClass();
  }

  @Before
  public void setUp() throws Exception {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

    Snippets.createCryptoKeyVersion(
        SnippetsIT.PROJECT_ID, SnippetsIT.KEY_RING_ID, SnippetsIT.CRYPTO_KEY_ID);
  }

  @Test
  public void listKeyRings_printsKeyRing() throws Exception {
    Quickstart.main(SnippetsIT.PROJECT_ID);

    assertThat(bout.toString()).contains(String.format("keyRings/%s", SnippetsIT.KEY_RING_ID));
  }
}
