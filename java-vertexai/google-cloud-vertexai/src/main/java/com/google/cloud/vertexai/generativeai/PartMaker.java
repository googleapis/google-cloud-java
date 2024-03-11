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

import com.google.cloud.vertexai.api.Blob;
import com.google.cloud.vertexai.api.FileData;
import com.google.cloud.vertexai.api.FunctionResponse;
import com.google.cloud.vertexai.api.Part;
import com.google.protobuf.ByteString;
import com.google.protobuf.NullValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import java.net.URI;
import java.util.Map;

/** Helper class to create {@link com.google.cloud.vertexai.api.Part} */
public class PartMaker {

  private PartMaker() {}

  /**
   * Makes a {@link com.google.cloud.vertexai.api.Part} from mimeType and data (or link to the
   * data).
   *
   * @param mimeType currently accepted values are "image/png", "image/jpeg", "video/mp4",
   *     "video/mpeg", "video/quicktime", "video/x-msvideo", "video/x-ms-wmv", "video/x-flv"
   * @param partData the following types can be accepted.
   *     <ul>
   *       <li>a String representing the uri of the data. Resulting Part will have fileData field
   *           set.
   *       <li>a GCS URI object. Resulting Part will have fileData field set.
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
      String uri = (String) partData;
      part =
          Part.newBuilder()
              .setFileData(FileData.newBuilder().setMimeType(mimeType).setFileUri(uri))
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
              + " byte[], String, URI, ByteString");
    }
    return part;
  }

  /**
   * Makes a {@link com.google.cloud.vertexai.api.Part} from the output of {@link
   * com.google.cloud.vertexai.api.FunctionCall}.
   *
   * @param name a string represents the name of the {@link
   *     com.google.cloud.vertexai.api.FunctionDeclaration}
   * @param response a structured JSON object containing any output from the function call
   */
  public static Part fromFunctionResponse(String name, Struct response) {
    return Part.newBuilder()
        .setFunctionResponse(FunctionResponse.newBuilder().setName(name).setResponse(response))
        .build();
  }

  /**
   * Makes a {@link com.google.cloud.vertexai.api.Part} from the result output of {@link
   * com.google.cloud.vertexai.api.FunctionCall}.
   *
   * @param name a string represents the name of the {@link
   *     com.google.cloud.vertexai.api.FunctionDeclaration}
   * @param response a map containing the output from the function call, supported output type:
   *     String, Double, Boolean, null
   */
  public static Part fromFunctionResponse(String name, Map<String, Object> response) {
    Struct.Builder structBuilder = Struct.newBuilder();
    response.forEach(
        (key, value) -> {
          if (value instanceof String) {
            String stringValue = (String) value;
            structBuilder.putFields(key, Value.newBuilder().setStringValue(stringValue).build());
          } else if (value instanceof Double) {
            Double doubleValue = (Double) value;
            structBuilder.putFields(key, Value.newBuilder().setNumberValue(doubleValue).build());
          } else if (value instanceof Boolean) {
            Boolean boolValue = (Boolean) value;
            structBuilder.putFields(key, Value.newBuilder().setBoolValue(boolValue).build());
          } else if (value == null) {
            structBuilder.putFields(
                key, Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build());
          } else {
            throw new IllegalArgumentException(
                "The value in the map can only be one of the following format: "
                    + "String, Double, Boolean, null.");
          }
        });

    return Part.newBuilder()
        .setFunctionResponse(FunctionResponse.newBuilder().setName(name).setResponse(structBuilder))
        .build();
  }
}
