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

// [START datalabeling_create_annotation_spec_set_beta]
import com.google.cloud.datalabeling.v1beta1.AnnotationSpec;
import com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet;
import com.google.cloud.datalabeling.v1beta1.CreateAnnotationSpecSetRequest;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient;
import com.google.cloud.datalabeling.v1beta1.DataLabelingServiceSettings;
import com.google.cloud.datalabeling.v1beta1.ProjectName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class CreateAnnotationSpecSet {

  // Create an annotation spec set.
  static void createAnnotationSpecSet(String projectId) throws IOException {
    // String projectId = "YOUR_PROJECT_ID";

    Map<String, String> annotationLabels = new HashMap<>();
    annotationLabels.put("label_1", "label_1_description");
    annotationLabels.put("label_2", "label_2_description");

    // [END datalabeling_create_annotation_spec_set_beta]
    String endpoint = System.getenv("DATALABELING_ENDPOINT");
    if (endpoint == null) {
      endpoint = DataLabelingServiceSettings.getDefaultEndpoint();
    }
    // [START datalabeling_create_annotation_spec_set_beta]

    DataLabelingServiceSettings settings =
        DataLabelingServiceSettings.newBuilder()
            // [END datalabeling_create_annotation_spec_set_beta]
            .setEndpoint(endpoint)
            // [START datalabeling_create_annotation_spec_set_beta]
            .build();
    try (DataLabelingServiceClient dataLabelingServiceClient =
        DataLabelingServiceClient.create(settings)) {
      ProjectName projectName = ProjectName.of(projectId);

      List<AnnotationSpec> annotationSpecs = new ArrayList<>();
      for (Entry<String, String> entry : annotationLabels.entrySet()) {
        AnnotationSpec annotationSpec =
            AnnotationSpec.newBuilder()
                .setDisplayName(entry.getKey())
                .setDescription(entry.getValue())
                .build();
        annotationSpecs.add(annotationSpec);
      }

      AnnotationSpecSet annotationSpecSet =
          AnnotationSpecSet.newBuilder()
              .setDisplayName("YOUR_ANNOTATION_SPEC_SET_DISPLAY_NAME")
              .setDescription("YOUR_DESCRIPTION")
              .addAllAnnotationSpecs(annotationSpecs)
              .build();

      CreateAnnotationSpecSetRequest request =
          CreateAnnotationSpecSetRequest.newBuilder()
              .setAnnotationSpecSet(annotationSpecSet)
              .setParent(projectName.toString())
              .build();

      AnnotationSpecSet result = dataLabelingServiceClient.createAnnotationSpecSet(request);

      System.out.format("Name: %s\n", result.getName());
      System.out.format("DisplayName: %s\n", result.getDisplayName());
      System.out.format("Description: %s\n", result.getDescription());
      System.out.format("Annotation Count: %d\n", result.getAnnotationSpecsCount());

      for (AnnotationSpec annotationSpec : result.getAnnotationSpecsList()) {
        System.out.format("\tDisplayName: %s\n", annotationSpec.getDisplayName());
        System.out.format("\tDescription: %s\n\n", annotationSpec.getDescription());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
// [END datalabeling_create_annotation_spec_set_beta]
