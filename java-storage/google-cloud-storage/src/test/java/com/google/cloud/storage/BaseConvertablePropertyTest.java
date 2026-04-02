/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage;

import static com.google.cloud.storage.JqwikTest.report;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.client.json.GenericJson;
import com.google.cloud.storage.Conversions.Codec;
import com.google.protobuf.Message;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.providers.TypeUsage;
import org.checkerframework.checker.nullness.qual.Nullable;

abstract class BaseConvertablePropertyTest<
    ModelT, ProtoT extends Message, ApiaryT extends GenericJson> {

  private final TypeUsage modelTType;
  private final TypeUsage protoTType;
  private final TypeUsage apiaryTType;

  BaseConvertablePropertyTest() {
    TypeUsage baseTypeUsage = findBaseTypeUsage(this.getClass());
    modelTType = baseTypeUsage.getTypeArgument(0);
    protoTType = baseTypeUsage.getTypeArgument(1);
    apiaryTType = baseTypeUsage.getTypeArgument(2);
  }

  /** Provide the codec instance used to convert between {@code ModelT} and {@code ProtoT} */
  Codec<ModelT, ProtoT> grpcCodec() {
    GrpcConversions instance = Conversions.grpc();
    return resolveCodec(instance, protoTType);
  }

  /** Provide the codec instance used to convert between {@code ModelT} and {@code ProtoT} */
  Codec<ModelT, ApiaryT> apiaryCodec() {
    JsonConversions instance = Conversions.json();
    return resolveCodec(instance, apiaryTType);
  }

  /** Report on detected edge cases for {@code ProtoT} */
  @Example
  final void edgeCases() {
    TypeUsage baseTypeUsage = findBaseTypeUsage(this.getClass());
    TypeUsage protoTType = baseTypeUsage.getTypeArgument(1);
    report(protoTType);
  }

  /**
   * Ensure that {@code @ForAll ProtoT} the codec provided by {@link #grpcCodec} can round trip each
   * {@code ProtoT} such that the provided value is equal to the round tripped value.
   *
   * <p>Note: round trip means A -> B -> A, in this case ProtoT -> ModelT -> ProtoT
   */
  @Property
  final void codecRoundTrip(@ForAll ProtoT p) {
    Codec<ModelT, ProtoT> codec = grpcCodec();
    ModelT model = codec.decode(p);
    ProtoT proto = codec.encode(model);

    assertThat(proto).isEqualTo(p);
  }

  /**
   * Ensure that {@code @ForAll ProtoT} the conversion chain ProtoT -> ModelT -> ApiaryT -> ModelT
   * -> ProtoT results in an equal value.
   *
   * <p>This test is intended to ensue compatibility of our conversions across both gRPC and apiary
   * models.
   */
  @Property
  final void codecCompatibilityRoundTrip(@ForAll ProtoT p) {
    Codec<ModelT, ProtoT> codecG = grpcCodec();
    Codec<ModelT, ApiaryT> codecA = apiaryCodec();

    ModelT model = codecG.decode(p);

    ApiaryT apiary = codecA.encode(model);
    ModelT model2 = codecA.decode(apiary);

    ProtoT actual = codecG.encode(model2);

    assertThat(actual).isEqualTo(p);
  }

  private static TypeUsage findBaseTypeUsage(
      @SuppressWarnings("rawtypes") Class<? extends BaseConvertablePropertyTest> c) {
    TypeUsage curr = TypeUsage.of(c);
    while (curr.getRawType() != BaseConvertablePropertyTest.class) {
      Optional<TypeUsage> superclass = curr.getSuperclass();
      if (!superclass.isPresent()) {
        throw new IllegalStateException(
            "Unable to locate base class" + BaseConvertablePropertyTest.class.getName());
      }
      curr = superclass.get();
    }
    return curr;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  private <X> Codec<ModelT, X> resolveCodec(Object instance, TypeUsage xType) {
    Method[] declaredMethods = instance.getClass().getDeclaredMethods();
    Method method = findCodecMethod(declaredMethods, instance.getClass(), xType);
    try {
      return (Codec<ModelT, X>) method.invoke(instance);
    } catch (IllegalAccessException | InvocationTargetException e) {
      throw new AssertionError("error attempting to resolve codec", e);
    }
  }

  private Method findCodecMethod(
      Method[] declaredMethods, Class<?> conversionsClass, TypeUsage serializedType) {
    Optional<Method> collect =
        Arrays.stream(declaredMethods)
            .filter(m -> m.getReturnType().isAssignableFrom(Codec.class))
            .filter(
                m -> {
                  TypeUsage returnType = TypeUsage.forType(m.getGenericReturnType());
                  return modelTType.equals(returnType.getTypeArgument(0))
                      && serializedType.equals(returnType.getTypeArgument(1));
                })
            .findFirst();
    assertWithMessage(
            "Unable to locate Codec<%s, %s> method in %s",
            modelTType, serializedType, conversionsClass)
        .that(collect.isPresent())
        .isTrue();
    return collect.get();
  }
}
