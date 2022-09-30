/*
 * Copyright 2020 Google Inc.
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

package dlp.snippets;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.common.collect.ImmutableList;
import com.google.privacy.dlp.v2.CreateInspectTemplateRequest;
import com.google.privacy.dlp.v2.DeleteInspectTemplateRequest;
import com.google.privacy.dlp.v2.InfoType;
import com.google.privacy.dlp.v2.InspectConfig;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.LocationName;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TemplatesTests extends TestBase {

  @Override
  protected ImmutableList<String> requiredEnvVars() {
    return ImmutableList.of("GOOGLE_APPLICATION_CREDENTIALS", "GOOGLE_CLOUD_PROJECT");
  }

  private static InspectTemplate createTemplate() throws IOException {
    try (DlpServiceClient dlpServiceClient = DlpServiceClient.create()) {
      List<InfoType> infoTypes =
          Stream.of("PHONE_NUMBER", "EMAIL_ADDRESS", "CREDIT_CARD_NUMBER")
              .map(it -> InfoType.newBuilder().setName(it).build())
              .collect(Collectors.toList());

      InspectConfig inspectConfig = InspectConfig.newBuilder().addAllInfoTypes(infoTypes).build();

      InspectTemplate inspectTemplate =
          InspectTemplate.newBuilder().setInspectConfig(inspectConfig).build();

      CreateInspectTemplateRequest createInspectTemplateRequest =
          CreateInspectTemplateRequest.newBuilder()
              .setParent(LocationName.of(PROJECT_ID, "global").toString())
              .setInspectTemplate(inspectTemplate)
              .build();

      return dlpServiceClient.createInspectTemplate(createInspectTemplateRequest);
    }
  }

  @Test
  public void testCreateInspectTemplate() throws Exception {
    TemplatesCreate.createInspectTemplate(PROJECT_ID);
    String output = bout.toString();
    assertThat(output).contains("Template created: ");

    // Delete the created template
    String templateId = output.split("Template created: ")[1].split("\n")[0];
    DeleteInspectTemplateRequest deleteInspectTemplateRequest =
        DeleteInspectTemplateRequest.newBuilder().setName(templateId).build();
    try (DlpServiceClient client = DlpServiceClient.create()) {
      client.deleteInspectTemplate(deleteInspectTemplateRequest);
    }
  }

  @Test
  public void testListInspectTemplate() throws Exception {
    TemplatesList.listInspectTemplates(PROJECT_ID);
    String output = bout.toString();
    assertThat(output).contains("Templates found:");
  }

  @Test
  public void testDeleteInspectTemplate() throws Exception {
    // Create a template to be deleted and extract its ID
    InspectTemplate template = createTemplate();
    String templateName = template.getName();
    String templateId;

    Matcher matcher = Pattern.compile("inspectTemplates/").matcher(templateName);
    if (matcher.find()) {
      templateId = templateName.substring(matcher.end());
    } else {
      throw new Exception("Could not extract templateId");
    }

    // Delete the template with the specified ID
    TemplatesDelete.deleteInspectTemplate(PROJECT_ID, templateId);
    String output = bout.toString();
    assertThat(output).contains("Deleted template:");
  }
}
