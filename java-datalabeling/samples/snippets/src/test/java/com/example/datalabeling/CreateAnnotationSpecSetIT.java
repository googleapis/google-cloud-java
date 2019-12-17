/*
 * Copyright 2019 Google LLC
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

package com.example.datalabeling;

import static org.junit.Assert.assertThat;

import com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListAnnotationSpecSetsPagedResponse;
import com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest;
import com.google.cloud.datalabeling.v1beta1.ProjectName;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Integration (system) tests for {@link CreateAnnotationSpecSet}.
 */
@RunWith(JUnit4.class)
@Ignore("b/146064330")
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class CreateAnnotationSpecSetIT {

  private ByteArrayOutputStream bout;

  private static String PROJECT_ID = System.getenv().get("GOOGLE_CLOUD_PROJECT");

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));
  }

  @After
  public void tearDown() {
    System.setOut(null);
    bout.reset();

    // Delete the Annotation Spec Sheet
    try (DataLabelingServiceClient dataLabelingServiceClient = DataLabelingServiceClient.create()) {
      ProjectName projectName = ProjectName.of(PROJECT_ID);
      ListAnnotationSpecSetsRequest listRequest = ListAnnotationSpecSetsRequest.newBuilder()
          .setParent(projectName.toString())
          .build();

      ListAnnotationSpecSetsPagedResponse response = dataLabelingServiceClient
          .listAnnotationSpecSets(listRequest);

      for (AnnotationSpecSet annotationSpecSet : response.getPage().iterateAll()) {
        if (annotationSpecSet.getDisplayName().equals("YOUR_ANNOTATION_SPEC_SET_DISPLAY_NAME")) {
          dataLabelingServiceClient.deleteAnnotationSpecSet(annotationSpecSet.getName());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testCreateAnnotationSpecSet() throws IOException {
    CreateAnnotationSpecSet.createAnnotationSpecSet(PROJECT_ID);

    String output = bout.toString();

    assertThat(output, CoreMatchers.containsString(
        "DisplayName: YOUR_ANNOTATION_SPEC_SET_DISPLAY_NAME"));
    assertThat(output, CoreMatchers.containsString("Description: YOUR_DESCRIPTION"));
    assertThat(output, CoreMatchers.containsString("Annotation Count: 2"));
  }
}
