/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.connection;

import static com.google.cloud.spanner.connection.ConnectionProperty.create;
import static com.google.cloud.spanner.connection.ConnectionProperty.createKey;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.NonNegativeIntegerConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.StringValueConverter;
import com.google.cloud.spanner.connection.ConnectionProperty.Context;
import java.util.Objects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConnectionPropertyTest {

  @Test
  public void testCreateKey() {
    assertEquals("my_property", createKey(/* extension= */ null, "my_property"));
    assertEquals("my_property", createKey(/* extension= */ null, "My_Property"));
    assertEquals("my_property", createKey(/* extension= */ null, "MY_PROPERTY"));
    assertEquals("my_extension.my_property", createKey("my_extension", "my_property"));
    assertEquals("my_extension.my_property", createKey("My_Extension", "My_Property"));
    assertEquals("my_extension.my_property", createKey("MY_EXTENSION", "MY_PROPERTY"));

    //noinspection DataFlowIssue
    assertThrows(SpannerException.class, () -> createKey("my_extension", /* name= */ null));
    assertThrows(SpannerException.class, () -> createKey("my_extension", ""));
  }

  @Test
  public void testCreate() {
    ConnectionProperty<String> property =
        create(
            "my_property",
            "Description of my_property",
            "default_value",
            StringValueConverter.INSTANCE,
            Context.USER);
    assertEquals("my_property", property.getName());
    assertEquals("Description of my_property", property.getDescription());
    assertEquals("default_value", property.getDefaultValue());
    assertEquals("my_value", Objects.requireNonNull(property.convert("my_value")).getValue());
    assertEquals(property.getContext(), Context.USER);
    assertEquals("my_property", property.getKey());

    ConnectionProperty<Integer> startupProperty =
        create(
            "STARTUP_PROPERTY",
            "Description of STARTUP_PROPERTY",
            1,
            NonNegativeIntegerConverter.INSTANCE,
            Context.STARTUP);
    // The name is folded to lower-case.
    assertEquals("startup_property", startupProperty.getName());
    assertEquals("Description of STARTUP_PROPERTY", startupProperty.getDescription());
    assertEquals(Integer.valueOf(1), startupProperty.getDefaultValue());
    assertEquals(
        Integer.valueOf(2), Objects.requireNonNull(startupProperty.convert("2")).getValue());
    assertEquals(startupProperty.getContext(), Context.STARTUP);
    assertEquals("startup_property", startupProperty.getKey());
  }

  @Test
  public void testEquals() {
    ConnectionProperty<String> property1 =
        new ConnectionProperty<>(
            /* extension= */ null,
            "my_property",
            "Description of property1",
            "default_value_1",
            null,
            StringValueConverter.INSTANCE,
            Context.STARTUP);
    ConnectionProperty<String> property2 =
        new ConnectionProperty<>(
            /* extension= */ null,
            "my_property",
            "Description of property2",
            "default_value_2",
            null,
            StringValueConverter.INSTANCE,
            Context.USER);
    ConnectionProperty<String> property3 =
        new ConnectionProperty<>(
            "my_extension",
            "my_property",
            "Description of property3",
            "default_value_3",
            null,
            StringValueConverter.INSTANCE,
            Context.STARTUP);
    ConnectionProperty<String> property4 =
        new ConnectionProperty<>(
            "my_extension",
            "my_property",
            "Description of property4",
            "default_value_4",
            null,
            StringValueConverter.INSTANCE,
            Context.USER);
    ConnectionProperty<String> property5 =
        new ConnectionProperty<>(
            /* extension= */ null,
            "my_other_property",
            "Description of property5",
            "default_value_5",
            null,
            StringValueConverter.INSTANCE,
            Context.STARTUP);
    ConnectionProperty<String> property6 =
        new ConnectionProperty<>(
            "my_extension",
            "my_other_property",
            "Description of property6",
            "default_value_6",
            null,
            StringValueConverter.INSTANCE,
            Context.STARTUP);
    ConnectionProperty<String> property7 =
        new ConnectionProperty<>(
            /* extension= */ null,
            "MY_PROPERTY",
            "Description of property7",
            "default_value_7",
            null,
            StringValueConverter.INSTANCE,
            Context.STARTUP);
    ConnectionProperty<String> property8 =
        new ConnectionProperty<>(
            "MY_EXTENSION",
            "my_property",
            "Description of property8",
            "default_value_8",
            null,
            StringValueConverter.INSTANCE,
            Context.STARTUP);
    ConnectionProperty<String> property9 =
        new ConnectionProperty<>(
            "my_extension",
            "MY_PROPERTY",
            "Description of property9",
            "default_value_9",
            null,
            StringValueConverter.INSTANCE,
            Context.STARTUP);

    // Equality is based only on the key.
    // The key is the lower case combination of extension and name.
    // If extension is null, then only the name is the key.

    // property1 = my_property
    assertEquals(property1, property2);
    assertNotEquals(property1, property3);
    assertNotEquals(property1, property4);
    assertNotEquals(property1, property5);
    assertNotEquals(property1, property6);
    assertEquals(property1, property7);
    assertNotEquals(property1, property8);
    assertNotEquals(property1, property9);

    // property2 = my_property
    assertEquals(property2, property1);
    assertNotEquals(property2, property3);
    assertNotEquals(property2, property4);
    assertNotEquals(property2, property5);
    assertNotEquals(property2, property6);
    assertEquals(property2, property7);
    assertNotEquals(property2, property8);
    assertNotEquals(property2, property9);

    // property3 = my_extension.my_property
    assertNotEquals(property3, property1);
    assertNotEquals(property3, property2);
    assertEquals(property3, property4);
    assertNotEquals(property3, property5);
    assertNotEquals(property3, property6);
    assertNotEquals(property3, property7);
    assertEquals(property3, property8);
    assertEquals(property3, property9);

    // property4 = my_extension.my_property
    assertNotEquals(property4, property1);
    assertNotEquals(property4, property2);
    assertEquals(property4, property3);
    assertNotEquals(property4, property5);
    assertNotEquals(property4, property6);
    assertNotEquals(property4, property7);
    assertEquals(property4, property8);
    assertEquals(property4, property9);

    // property5 = my_other_property
    assertNotEquals(property5, property1);
    assertNotEquals(property5, property2);
    assertNotEquals(property5, property3);
    assertNotEquals(property5, property4);
    assertNotEquals(property5, property6);
    assertNotEquals(property5, property7);
    assertNotEquals(property5, property8);
    assertNotEquals(property5, property9);

    // property6 = my_extension.my_other_property
    assertNotEquals(property6, property1);
    assertNotEquals(property6, property2);
    assertNotEquals(property6, property3);
    assertNotEquals(property6, property4);
    assertNotEquals(property6, property5);
    assertNotEquals(property6, property7);
    assertNotEquals(property6, property8);
    assertNotEquals(property6, property9);

    // property7 = MY_PROPERTY (same as property1 and property2)
    assertEquals(property7, property1);
    assertEquals(property7, property2);
    assertNotEquals(property7, property3);
    assertNotEquals(property7, property4);
    assertNotEquals(property7, property5);
    assertNotEquals(property7, property6);
    assertNotEquals(property7, property8);
    assertNotEquals(property7, property9);

    // property8 = MY_EXTENSION.my_property (same as property4)
    assertNotEquals(property8, property1);
    assertNotEquals(property8, property2);
    assertEquals(property8, property3);
    assertEquals(property8, property4);
    assertNotEquals(property8, property5);
    assertNotEquals(property8, property6);
    assertNotEquals(property8, property7);
    assertEquals(property8, property9);

    // property9 = my_extension.MY_PROPERTY (same as property4 and property8)
    assertNotEquals(property9, property1);
    assertNotEquals(property9, property2);
    assertEquals(property9, property3);
    assertEquals(property9, property4);
    assertNotEquals(property9, property5);
    assertNotEquals(property9, property6);
    assertNotEquals(property9, property7);
    assertEquals(property9, property8);
  }

  @Test
  public void testConvert() {
    ConnectionProperty<Integer> property =
        create(
            "my_property",
            "Description of my_property",
            1,
            NonNegativeIntegerConverter.INSTANCE,
            Context.STARTUP);
    assertEquals(Integer.valueOf(100), Objects.requireNonNull(property.convert("100")).getValue());
    assertThrows(SpannerException.class, () -> property.convert("foo"));
    assertThrows(SpannerException.class, () -> property.convert("-100"));
  }

  @Test
  public void testCreateInitialValue() {
    ConnectionProperty<String> property =
        create(
            "my_property",
            "Description of my_property",
            "default_value",
            StringValueConverter.INSTANCE,
            Context.USER);

    ConnectionPropertyValue<String> initialValue = property.createInitialValue(null);
    assertEquals(property.getDefaultValue(), initialValue.getValue());
    assertEquals(property.getDefaultValue(), initialValue.getResetValue());
    assertSame(initialValue.getProperty(), property);

    ConnectionPropertyValue<String> startupValue =
        new ConnectionPropertyValue<>(property, "other_value", "other_value");
    ConnectionPropertyValue<String> initialValueWithStartupValue =
        property.createInitialValue(startupValue);
    assertEquals("other_value", initialValueWithStartupValue.getValue());
    assertEquals("other_value", initialValueWithStartupValue.getResetValue());
    assertSame(initialValueWithStartupValue.getProperty(), property);
  }
}
