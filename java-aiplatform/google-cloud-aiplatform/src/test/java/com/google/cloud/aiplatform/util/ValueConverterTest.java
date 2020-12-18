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

package com.google.cloud.aiplatform.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.cloud.aiplatform.v1beta1.schema.trainingjob.definition.AutoMlImageClassificationInputs;
import com.google.cloud.aiplatform.v1beta1.schema.trainingjob.definition.AutoMlImageClassificationInputs.ModelType;
import com.google.gson.JsonObject;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import com.google.protobuf.util.JsonFormat;
import java.util.Collection;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class ValueConverterTest {

  @Test
  public void testValueConverterToValue() throws InvalidProtocolBufferException {
    AutoMlImageClassificationInputs testObjectInputs =
        AutoMlImageClassificationInputs.newBuilder()
            .setModelType(ModelType.CLOUD)
            .setBudgetMilliNodeHours(8000)
            .setMultiLabel(true)
            .setDisableEarlyStopping(false)
            .build();

    Value actualConvertedValue = ValueConverter.toValue(testObjectInputs);

    Struct actualStruct = actualConvertedValue.getStructValue();
    assertEquals(3, actualStruct.getFieldsCount());

    Collection<Object> innerFields = actualStruct.getAllFields().values();
    Collection<MapEntry> fieldEntries = (Collection<MapEntry>) innerFields.toArray()[0];

    MapEntry actualBoolValueEntry = null;
    MapEntry actualStringValueEntry = null;
    MapEntry actualNumberValueEntry = null;

    for (MapEntry entry : fieldEntries) {
      String key = entry.getKey().toString();
      if (key.equals("multiLabel")) {
        actualBoolValueEntry = entry;
      } else if (key.equals("modelType")) {
        actualStringValueEntry = entry;
      } else if (key.equals("budgetMilliNodeHours")) {
        actualNumberValueEntry = entry;
      }
    }

    Value actualBoolValue = (Value) actualBoolValueEntry.getValue();
    assertEquals(testObjectInputs.getMultiLabel(), actualBoolValue.getBoolValue());

    Value actualStringValue = (Value) actualStringValueEntry.getValue();
    assertEquals("CLOUD", actualStringValue.getStringValue());

    Value actualNumberValue = (Value) actualNumberValueEntry.getValue();
    // protobuf stores int64 values as strings rather than numbers
    long actualNumber = Long.parseLong(actualNumberValue.getStringValue());
    assertEquals(testObjectInputs.getBudgetMilliNodeHours(), actualNumber);
  }

  @Test
  public void testValueConverterFromValue() throws InvalidProtocolBufferException {

    JsonObject testJsonInputs = new JsonObject();
    testJsonInputs.addProperty("multi_label", true);
    testJsonInputs.addProperty("model_type", "CLOUD");
    testJsonInputs.addProperty("budget_milli_node_hours", 8000);

    Value.Builder valueBuilder = Value.newBuilder();
    JsonFormat.parser().merge(testJsonInputs.toString(), valueBuilder);
    Value testValueInputs = valueBuilder.build();

    AutoMlImageClassificationInputs actualInputs =
        (AutoMlImageClassificationInputs)
            ValueConverter.fromValue(AutoMlImageClassificationInputs.newBuilder(), testValueInputs);

    assertEquals(8000, actualInputs.getBudgetMilliNodeHours());
    assertEquals(true, actualInputs.getMultiLabel());
    assertEquals(ModelType.CLOUD, actualInputs.getModelType());
  }

  @Test
  public void testValueConverterFromValueWithBadInputs() throws InvalidProtocolBufferException {
    JsonObject testBadJsonInputs = new JsonObject();
    testBadJsonInputs.addProperty("wrong_key", "some_value");

    Value.Builder badValueBuilder = Value.newBuilder();
    JsonFormat.parser().merge(testBadJsonInputs.toString(), badValueBuilder);
    final Value testBadValueInputs = badValueBuilder.build();

    assertThrows(
        InvalidProtocolBufferException.class,
        new ThrowingRunnable() {
          @Override
          public void run() throws Throwable {
            AutoMlImageClassificationInputs actualBadInput =
                (AutoMlImageClassificationInputs)
                    ValueConverter.fromValue(
                        AutoMlImageClassificationInputs.newBuilder(), testBadValueInputs);
          }
        });
  }
}
