// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.utils;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class JavaStyleTest {
  @Test
  void emptyOrNull() {
    String value = "";
    assertEquals("", JavaStyle.toLowerCamelCase(value));
    assertEquals("", JavaStyle.toUpperCamelCase(value));

    value = null;
    assertThat(JavaStyle.toLowerCamelCase(value)).isNull();
    assertThat(JavaStyle.toUpperCamelCase(value)).isNull();
  }

  @Test
  void singleWord() {
    String value = "dog";
    assertEquals("dog", JavaStyle.toLowerCamelCase(value));
    assertEquals("Dog", JavaStyle.toUpperCamelCase(value));
  }

  @Test
  void fromLowerSnake() {
    String value = "factory_decorator_delegate_impl";
    assertEquals("factoryDecoratorDelegateImpl", JavaStyle.toLowerCamelCase(value));
    assertEquals("FactoryDecoratorDelegateImpl", JavaStyle.toUpperCamelCase(value));
  }

  @Test
  void fromUpperSnake() {
    String value = "FACTORY_DECORATOR_DELEGATE_IMPL";
    assertEquals("factoryDecoratorDelegateImpl", JavaStyle.toLowerCamelCase(value));
    assertEquals("FactoryDecoratorDelegateImpl", JavaStyle.toUpperCamelCase(value));
  }

  @Test
  void fromLowerCamelCase() {
    String value = "factoryDecoratorDelegateImpl";
    assertEquals("factoryDecoratorDelegateImpl", JavaStyle.toLowerCamelCase(value));
    assertEquals("FactoryDecoratorDelegateImpl", JavaStyle.toUpperCamelCase(value));
  }

  @Test
  void fromUpperCamelCase() {
    String value = "FactoryDecoratorDelegateImpl";
    assertEquals("factoryDecoratorDelegateImpl", JavaStyle.toLowerCamelCase(value));
    assertEquals("FactoryDecoratorDelegateImpl", JavaStyle.toUpperCamelCase(value));
  }

  @Test
  void wordAndNumber() {
    String value = "dog2";
    assertEquals("dog2", JavaStyle.toLowerCamelCase(value));
    assertEquals("Dog2", JavaStyle.toUpperCamelCase(value));
    value = "dog_2";
    assertEquals("dog2", JavaStyle.toLowerCamelCase(value));
    assertEquals("Dog2", JavaStyle.toUpperCamelCase(value));
  }

  @Test
  void upperWordAndNumber() {
    String value = "Dog_v2";
    assertEquals("dogV2", JavaStyle.toLowerCamelCase(value));
    assertEquals("DogV2", JavaStyle.toUpperCamelCase(value));
  }

  @Test
  void upperWordAndCharsAfterDigit() {
    String value = "dogV2cc";
    assertEquals("dogV2Cc", JavaStyle.toLowerCamelCase(value));
    assertEquals("DogV2Cc", JavaStyle.toUpperCamelCase(value));

    value = "dogv2_cc";
    assertEquals("dogv2Cc", JavaStyle.toLowerCamelCase(value));
    assertEquals("Dogv2Cc", JavaStyle.toUpperCamelCase(value));

    value = "dog_v2_cc";
    assertEquals("dogV2Cc", JavaStyle.toLowerCamelCase(value));
    assertEquals("DogV2Cc", JavaStyle.toUpperCamelCase(value));

    value = "foo1bar2car3";
    assertEquals("foo1Bar2Car3", JavaStyle.toLowerCamelCase(value));
    assertEquals("Foo1Bar2Car3", JavaStyle.toUpperCamelCase(value));
  }

  @Test
  void acronyms() {
    String value = "iam_http_xml_dog";
    assertEquals("iamHttpXmlDog", JavaStyle.toLowerCamelCase(value));
    assertEquals("IamHttpXmlDog", JavaStyle.toUpperCamelCase(value));
    value = "IAM_HTTP_XML_DOG";
    assertEquals("iamHttpXmlDog", JavaStyle.toLowerCamelCase(value));
    assertEquals("IamHttpXmlDog", JavaStyle.toUpperCamelCase(value));
  }

  @Test
  void keyword() {
    String value = "import";
    assertEquals("import_", JavaStyle.toLowerCamelCase(value));
    assertEquals("Import", JavaStyle.toUpperCamelCase(value));
    value = "IMPORT_";
    assertEquals("import_", JavaStyle.toLowerCamelCase(value));
    assertEquals("Import", JavaStyle.toUpperCamelCase(value));
  }
}
