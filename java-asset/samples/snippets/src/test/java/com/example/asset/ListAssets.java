/*
 * Copyright 2020 Google LLC
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

package com.example.asset;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.ServiceOptions;
import com.google.cloud.asset.v1.ContentType;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for list assets sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class ListAssets {
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testListAssetsExample() throws Exception {
    // Use the default project Id (configure it by setting environment variable
    // "GOOGLE_CLOUD_PROJECT").
    String projectId = ServiceOptions.getDefaultProjectId();
    String[] assetTypes = {"storage.googleapis.com/Bucket", "bigquery.googleapis.com/Table"};
    ContentType contentType = ContentType.CONTENT_TYPE_UNSPECIFIED;
    ListAssetsExample.listAssets(projectId, assetTypes, contentType);
    String got = bout.toString();
    if (!got.isEmpty()) {
      assertThat(got).contains("asset");
    }
  }

  @Test
  public void testListAssetsRelationshipExample() throws Exception {
    // Use the default project Id (configure it by setting environment variable
    // "GOOGLE_CLOUD_PROJECT").
    String projectId = ServiceOptions.getDefaultProjectId();
    String[] assetTypes = {"compute.googleapis.com/Instance", "compute.googleapis.com/Disk"};
    ContentType contentType = ContentType.RELATIONSHIP;
    ListAssetsExample.listAssets(projectId, assetTypes, contentType);
    String got = bout.toString();
    if (!got.isEmpty()) {
      assertThat(got).contains("asset");
    }
  }
}
