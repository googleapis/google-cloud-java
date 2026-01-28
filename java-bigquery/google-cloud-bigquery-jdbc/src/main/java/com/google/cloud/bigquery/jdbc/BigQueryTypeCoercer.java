/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.api.core.InternalApi;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.exception.BigQueryJdbcCoercionException;
import com.google.cloud.bigquery.exception.BigQueryJdbcCoercionNotFoundException;
import java.util.Map;

/**
 * Provides a declarative mechanism for coercing an object from one type to another. For example,
 * coercion of {@link String} to {@link Integer} can be achieved like this:
 *
 * <pre>
 *   Integer value = BigQueryTypeCoercer.INSTANCE.coerceTo(Integer.class, "3452148");
 *   System.out.println(value); // 3452148
 * </pre>
 *
 * A {@link BigQueryTypeCoercer} is baked with all the default {@link BigQueryCoercion}s from {@link
 * BigQueryDefaultCoercions} to coerce all the primitive types.
 *
 * <p>It is also possible to extend the behaviour of {@link BigQueryTypeCoercer} to other custom
 * user defined types by creating an implementation of {@link BigQueryCoercion} and register it with
 * {@link BigQueryTypeCoercerBuilder} using it's {@link
 * BigQueryTypeCoercerBuilder#registerTypeCoercion(BigQueryCoercion)} method.
 *
 * <pre>
 *   public class TextToStringCoercion extends BigQueryBigQueryCoercion<Text, String>{
 *
 *    public TextToStringCoercion() {
 *       super(Text.class, String.class);
 *    }
 *
 *    &#064;Override
 *    String coerce(Text text) {
 *       return text.toString();  // logic to coerce from Text type to String type
 *    }
 *  }
 * </pre>
 *
 * and use it like this
 *
 * <pre>
 *    byte[] bytesArray = {72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33};
 *    Text text = new Text(bytesArray);
 *
 *    BigQueryTypeCoercer typeCoercer = new BigQueryTypeCoercerBuilder()
 *         .registerCoercion(new TextToStringCoercion())  // registering a custom coercion
 *         .build();
 *    System.out.println(typeCoercer.coerceTo(String.class, text));  //  Hello World!
 * </pre>
 */
@InternalApi
class BigQueryTypeCoercer {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryTypeCoercer.class.getName());

  /** A {@link BigQueryTypeCoercer} instance with all the inbuilt {@link BigQueryCoercion}s */
  static BigQueryTypeCoercer INSTANCE;

  static {
    INSTANCE = BigQueryDefaultCoercions.builder().build();
  }

  private final Map<Class<?>, Map<Class<?>, BigQueryCoercion<?, ?>>> allCoercions;

  BigQueryTypeCoercer(Map<Class<?>, Map<Class<?>, BigQueryCoercion<?, ?>>> allCoercions) {
    this.allCoercions = allCoercions;
  }

  /**
   * Coerce an object to the type specified.
   *
   * @param value the object that needs to be coerced.
   * @param targetClass the target class for the coercion
   * @throws BigQueryJdbcCoercionNotFoundException when coercion can not be performed to the target
   *     type.
   * @throws BigQueryJdbcCoercionException when an error is encountered while performing the
   *     coercion.
   */
  <T> T coerceTo(Class<T> targetClass, Object value) {
    Class<?> sourceClass = value == null ? Void.class : value.getClass();
    // FieldValue object for null-values requires special check
    if (sourceClass == FieldValue.class && ((FieldValue.class.cast(value)).isNull())) {
      sourceClass = Void.class;
    }
    // No coercion needed
    if (sourceClass.equals(targetClass)) {
      return targetClass.cast(value);
    }
    BigQueryCoercion<Object, T> coercion = findCoercion(sourceClass, targetClass);
    LOG.finest(() -> String.format("%s coercion for %s", coercion, value));
    // Value is null case & no explicit coercion
    if (sourceClass == Void.class && coercion == null) {
      return null;
    }
    if (coercion == null) {
      if (targetClass.equals(String.class)) {
        return (T) value.toString();
      }
      throw new BigQueryJdbcCoercionNotFoundException(sourceClass, targetClass);
    }
    try {
      return coercion.coerce(sourceClass != Void.class ? value : null);
    } catch (Exception ex) {
      throw new BigQueryJdbcCoercionException(ex);
    }
  }

  /**
   * Creates a {@link BigQueryTypeCoercerBuilder} with all the default coercions from {@link
   * BigQueryDefaultCoercions}.
   */
  static BigQueryTypeCoercerBuilder builder() {
    return BigQueryDefaultCoercions.builder();
  }

  private <T> BigQueryCoercion<Object, T> findCoercion(Class<?> sourceClass, Class<T> targetClass) {
    Map<Class<?>, BigQueryCoercion<?, ?>> bySourceMap = this.allCoercions.get(sourceClass);
    // AutoValue generated concrete classes are registered with their abstract classes and not the
    // concrete class. Lets make sure the we can find the registered abstract class for such
    // classes. The abstract class in these cases would be the super class of the generated
    // AutoValue concrete classes.
    if (bySourceMap == null) {
      Class<?> registeredAbstractClass = sourceClass.getSuperclass();
      bySourceMap = this.allCoercions.get(registeredAbstractClass);
    }
    // If we still can't find the coercion source class entry then just return.
    if (bySourceMap == null) {
      return null;
    }
    return (BigQueryCoercion<Object, T>) bySourceMap.get(targetClass);
  }
}
