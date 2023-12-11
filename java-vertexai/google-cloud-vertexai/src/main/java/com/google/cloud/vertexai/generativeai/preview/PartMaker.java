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

import com.google.cloud.vertexai.api.Blob;
import com.google.cloud.vertexai.api.FileData;
import com.google.cloud.vertexai.api.Part;
import com.google.protobuf.ByteString;
import java.net.URI;
import java.net.URL;

/** */
public class PartMaker {

  private PartMaker() {}

  /**
   * Make a {@link com.google.cloud.vertexai.api.Part} from mimeType and data (or link to the data).
   *
   * @param mimeType currently accepted values are "image/png", "image/jpeg", "video/mp4",
   *     "video/mpeg", "video/quicktime", "video/x-msvideo", "video/x-ms-wmv", "video/x-flv"
   * @param partData the following types can be accepted.
   *     <ul>
   *       <li>a String representing the url of the data. Resulting Part will have fileData field
   *           set.
   *       <li>a URI object. Resulting Part will have fileData field set.
   *       <li>a URL object. Resulting Part will have fileData field set.
   *       <li>byte arrays that represents the actual data. Resulting Part will have inlineData
   *           field set.
   *       <li>com.google.protobuf.ByteString that represents the actual data. Resulting Part will
   *           have inlineData field set.
   *     </ul>
   */
  public static Part fromMimeTypeAndData(String mimeType, Object partData) {
    Part part;
    if (partData instanceof byte[]) {
      byte[] bytes = (byte[]) partData;
      ByteString byteData = ByteString.copyFrom(bytes);
      part =
          Part.newBuilder()
              .setInlineData(Blob.newBuilder().setMimeType(mimeType).setData(byteData))
              .build();
    } else if (partData instanceof String) {
      String url = (String) partData;
      part =
          Part.newBuilder()
              .setFileData(FileData.newBuilder().setMimeType(mimeType).setFileUri(url))
              .build();
    } else if (partData instanceof URL) {
      URL url = (URL) partData;
      part =
          Part.newBuilder()
              .setFileData(
                  FileData.newBuilder().setMimeType(mimeType).setFileUri(partData.toString()))
              .build();

    } else if (partData instanceof URI) {
      URI uri = (URI) partData;
      part =
          Part.newBuilder()
              .setFileData(FileData.newBuilder().setMimeType(mimeType).setFileUri(uri.toString()))
              .build();
    } else if (partData instanceof ByteString) {
      ByteString byteData = (ByteString) partData;
      part =
          Part.newBuilder()
              .setInlineData(Blob.newBuilder().setMimeType(mimeType).setData(byteData))
              .build();
    } else {
      throw new IllegalArgumentException(
          "The second element of the input List can only be one of the following format:"
              + " byte[], String, URL, URI, ByteString");
    }
    return part;
  }
}
