/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.vertexai.generativeai.preview;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.vertexai.api.Content;
import com.google.protobuf.ByteString;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class ContentMakerTest {
  @Test
  public void fromString_returnsContentWithText() {
    String stringInput = "string input";
    Content content = ContentMaker.fromString(stringInput);

    assertThat(content.getRole()).isEqualTo("user");
    assertThat(content.getParts(0).getText()).isEqualTo(stringInput);
  }

  @Test
  public void forRole_returnsContentWithArbitraryRoleSet() {
    // Although in our docstring, we said only three roles are acceptable, we make sure the code
    // can evolve with arbitrary roles (the backend API doesn't reject any role, nor is it forbidden
    // as model input. But the model wasn't trained/evaluated this way).
    String role = "arbitrary_role";
    String stringInput = "string input";

    Content content = ContentMaker.forRole(role).fromString(stringInput);
    assertThat(content.getRole()).isEqualTo(role);
    assertThat(content.getParts(0).getText()).isEqualTo(stringInput);

    // Make sure when we use the ContentMaker without `forRole` again, the default role becomes
    // "user".
    Content anotherContent = ContentMaker.fromString(stringInput);
    assertThat(anotherContent.getRole()).isEqualTo("user");
    assertThat(anotherContent.getParts(0).getText()).isEqualTo(stringInput);
  }

  @Test
  public void fromMultiModalData_returnsContentWithMultiModalityParts()
      throws MalformedURLException, URISyntaxException {
    String stringInput = "string input";

    String mimeTypeForBytes = "application/octet-stream";
    byte[] bytesInput = new byte[] {1, 2, 3};

    String mimeTypeForURLinString = "image/jpeg";
    String fileUrlInString = "https://example.com/image.jpg";

    String mimeTypeForURL = "image/png";
    URL fileUrl = new URL("https://example.com/image.png");

    String mimeTypeForURI = "image/gif";
    URI fileUri = new URI("https://example.com/image.gif");

    String mimeTypeForByteString = "image/gif";
    ByteString byteString = ByteString.copyFrom(bytesInput);

    Content content =
        ContentMaker.fromMultiModalData(
            stringInput,
            PartMaker.fromMimeTypeAndData(mimeTypeForBytes, bytesInput),
            PartMaker.fromMimeTypeAndData(mimeTypeForURLinString, fileUrlInString),
            PartMaker.fromMimeTypeAndData(mimeTypeForURL, fileUrl),
            PartMaker.fromMimeTypeAndData(mimeTypeForURI, fileUri),
            PartMaker.fromMimeTypeAndData(mimeTypeForByteString, byteString));

    assertThat(content.getRole()).isEqualTo("user");

    assertThat(content.getParts(0).getText()).isEqualTo(stringInput);

    assertThat(content.getParts(1).getInlineData().getMimeType())
        .isEqualTo("application/octet-stream");
    assertThat(content.getParts(1).getInlineData().getData())
        .isEqualTo(ByteString.copyFrom(bytesInput));

    assertThat(content.getParts(2).getFileData().getMimeType()).isEqualTo("image/jpeg");
    assertThat(content.getParts(2).getFileData().getFileUri()).isEqualTo(fileUrlInString);

    assertThat(content.getParts(3).getFileData().getMimeType()).isEqualTo("image/png");
    assertThat(content.getParts(3).getFileData().getFileUri()).isEqualTo(fileUrl.toString());

    assertThat(content.getParts(4).getFileData().getMimeType()).isEqualTo("image/gif");
    assertThat(content.getParts(4).getFileData().getFileUri()).isEqualTo(fileUri.toString());

    assertThat(content.getParts(5).getInlineData().getMimeType()).isEqualTo("image/gif");
    assertThat(content.getParts(5).getInlineData().getData()).isEqualTo(byteString);
  }
}
