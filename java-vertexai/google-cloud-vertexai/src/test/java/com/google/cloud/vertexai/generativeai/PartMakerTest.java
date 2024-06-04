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

import com.google.cloud.vertexai.api.Part;
import com.google.protobuf.ByteString;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
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

  @Test
  public void testFromFunctionResponseWithStruct_containsRightNameAndValues() {
    String functionName = "getCurrentWeather";
    Struct functionResponse =
        Struct.newBuilder()
            .putFields("currentWeather", Value.newBuilder().setStringValue("Super nice!").build())
            .putFields("currentTemperature", Value.newBuilder().setNumberValue(85.0).build())
            .putFields("isRaining", Value.newBuilder().setBoolValue(false).build())
            .build();

    Part part = PartMaker.fromFunctionResponse(functionName, functionResponse);

    assertThat(part.getFunctionResponse().getName()).isEqualTo("getCurrentWeather");
    assertThat(part.getFunctionResponse().getResponse()).isEqualTo(functionResponse);
  }

  @Test
  public void testFromFunctionResponseWithMap_containsRightNameAndValues() {
    String functionName = "getCurrentWeather";
    Map<String, Object> functionResponse = new HashMap<>();
    functionResponse.put("currentWeather", "Super nice!");
    functionResponse.put("currentTemperature", 85.0);
    functionResponse.put("isRaining", false);
    functionResponse.put("other", null);

    Part part = PartMaker.fromFunctionResponse(functionName, functionResponse);

    assertThat(part.getFunctionResponse().getName()).isEqualTo("getCurrentWeather");

    Map<String, Value> fieldsMap = part.getFunctionResponse().getResponse().getFieldsMap();
    assertThat(fieldsMap.get("currentWeather").getStringValue()).isEqualTo("Super nice!");
    assertThat(fieldsMap.get("currentTemperature").getNumberValue()).isEqualTo(85.0);
    assertThat(fieldsMap.get("isRaining").getBoolValue()).isEqualTo(false);
    assertThat(fieldsMap.get("other").hasNullValue()).isEqualTo(true);
  }

  @Test
  public void testFromFunctionResponseWithNumberValues_containsRightNameAndValues() {
    String functionName = "getCurrentWeather";
    Map<String, Object> functionResponse = new HashMap<>();
    functionResponse.put("integerNumber", 85);
    functionResponse.put("doubleNumber", 85.0);
    functionResponse.put("floatNumber", 85.0f);
    functionResponse.put("longNumber", 85L);
    functionResponse.put("shortNumber", (short) 85);

    Part part = PartMaker.fromFunctionResponse(functionName, functionResponse);
    Map<String, Value> fieldsMap = part.getFunctionResponse().getResponse().getFieldsMap();

    assertThat(part.getFunctionResponse().getName()).isEqualTo("getCurrentWeather");
    assertThat(fieldsMap.get("integerNumber").getNumberValue()).isEqualTo(85.0);
    assertThat(fieldsMap.get("doubleNumber").getNumberValue()).isEqualTo(85.0);
    assertThat(fieldsMap.get("floatNumber").getNumberValue()).isEqualTo(85.0);
    assertThat(fieldsMap.get("longNumber").getNumberValue()).isEqualTo(85.0);
    assertThat(fieldsMap.get("shortNumber").getNumberValue()).isEqualTo(85.0);
  }

  @Test
  public void testFromFunctionResponseWithInvalidMap_throwsIllegalArgumentException() {
    String functionName = "getCurrentWeather";
    Map<String, Object> invalidResponse = new HashMap<>();
    invalidResponse.put("currentWeather", new byte[] {1, 2, 3});
    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> PartMaker.fromFunctionResponse(functionName, invalidResponse));
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo(
            "The value in the map can only be one of the following format: "
                + "String, Number, Boolean, null.");
  }
}
