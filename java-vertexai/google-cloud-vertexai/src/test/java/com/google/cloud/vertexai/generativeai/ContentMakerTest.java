/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.vertexai.generativeai;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.vertexai.api.Content;
import com.google.protobuf.ByteString;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
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
  public void fromString_throwsIllegalArgumentException_withEmptyString() {
    String stringInput = "";

    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> ContentMaker.fromString(stringInput));
    assertThat(thrown).hasMessageThat().isEqualTo("text message can't be null or empty.");
  }

  @Test
  public void fromString_throwsIllegalArgumentException_withNullString() {
    String stringInput = null;

    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> ContentMaker.fromString(stringInput));
    assertThat(thrown).hasMessageThat().isEqualTo("text message can't be null or empty.");
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

    String mimeTypeForURIinString = "image/jpeg";
    String fileUriInString = "gs://my-bucket/image.jpg";

    String mimeTypeForURI = "image/gif";
    URI fileUri = new URI("gs://my-bucket/image.gif");

    String mimeTypeForByteString = "image/gif";
    ByteString byteString = ByteString.copyFrom(bytesInput);

    Content content =
        ContentMaker.fromMultiModalData(
            stringInput,
            PartMaker.fromMimeTypeAndData(mimeTypeForBytes, bytesInput),
            PartMaker.fromMimeTypeAndData(mimeTypeForURIinString, fileUriInString),
            PartMaker.fromMimeTypeAndData(mimeTypeForURI, fileUri),
            PartMaker.fromMimeTypeAndData(mimeTypeForByteString, byteString));

    assertThat(content.getRole()).isEqualTo("user");

    assertThat(content.getParts(0).getText()).isEqualTo(stringInput);

    assertThat(content.getParts(1).getInlineData().getMimeType())
        .isEqualTo("application/octet-stream");
    assertThat(content.getParts(1).getInlineData().getData())
        .isEqualTo(ByteString.copyFrom(bytesInput));

    assertThat(content.getParts(2).getFileData().getMimeType()).isEqualTo("image/jpeg");
    assertThat(content.getParts(2).getFileData().getFileUri()).isEqualTo(fileUriInString);

    assertThat(content.getParts(3).getFileData().getMimeType()).isEqualTo("image/gif");
    assertThat(content.getParts(3).getFileData().getFileUri()).isEqualTo(fileUri.toString());

    assertThat(content.getParts(4).getInlineData().getMimeType()).isEqualTo("image/gif");
    assertThat(content.getParts(4).getInlineData().getData()).isEqualTo(byteString);
  }
}
