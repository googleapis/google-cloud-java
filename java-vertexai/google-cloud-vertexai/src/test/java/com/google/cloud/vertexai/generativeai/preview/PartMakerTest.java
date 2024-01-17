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

package com.google.cloud.vertexai.generativeai.preview;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.vertexai.api.Part;
import com.google.protobuf.ByteString;
import java.net.URI;
import java.net.URISyntaxException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class PartMakerTest {
  @Test
  public void fromMimeTypeAndData_dataInByteArray() {
    String mimeTypeForBytes = "application/octet-stream";
    byte[] bytesInput = new byte[] {1, 2, 3};

    Part part = PartMaker.fromMimeTypeAndData(mimeTypeForBytes, bytesInput);

    assertThat(part.getInlineData().getMimeType()).isEqualTo("application/octet-stream");
    assertThat(part.getInlineData().getData()).isEqualTo(ByteString.copyFrom(bytesInput));
  }

  @Test
  public void fromMimeTypeAndData_dataInByteString() {
    String mimeTypeForByteString = "image/gif";
    byte[] bytesInput = new byte[] {1, 2, 3};
    ByteString byteString = ByteString.copyFrom(bytesInput);

    Part part = PartMaker.fromMimeTypeAndData(mimeTypeForByteString, byteString);

    assertThat(part.getInlineData().getMimeType()).isEqualTo("image/gif");
    assertThat(part.getInlineData().getData()).isEqualTo(byteString);
  }

  @Test
  public void fromMimeTypeAndData_dataInString() {
    String mimeTypeForURIinString = "image/jpeg";
    String fileUriInString = "gs://my-bucket/image.jpg";

    Part part = PartMaker.fromMimeTypeAndData(mimeTypeForURIinString, fileUriInString);

    assertThat(part.getFileData().getMimeType()).isEqualTo("image/jpeg");
    assertThat(part.getFileData().getFileUri()).isEqualTo(fileUriInString);
  }

  @Test
  public void fromMimeTypeAndData_dataInURI() throws URISyntaxException {

    String mimeTypeForURI = "image/png";
    URI fileUri = new URI("gs://my-bucket/image.png");
    Part part = PartMaker.fromMimeTypeAndData(mimeTypeForURI, fileUri);

    assertThat(part.getFileData().getMimeType()).isEqualTo("image/png");
    assertThat(part.getFileData().getFileUri()).isEqualTo(fileUri.toString());
  }
}
