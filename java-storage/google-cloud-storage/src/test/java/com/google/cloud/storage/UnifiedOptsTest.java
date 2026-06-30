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

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertThrows;

import com.google.cloud.storage.UnifiedOpts.Crc32cMatch;
import com.google.cloud.storage.UnifiedOpts.DefaultHasherSelector;
import com.google.cloud.storage.UnifiedOpts.HasherSelector;
import com.google.cloud.storage.UnifiedOpts.Md5Match;
import com.google.cloud.storage.UnifiedOpts.ObjectSourceOpt;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.crypto.SecretKey;
import org.junit.Test;
import org.junit.runners.model.MultipleFailureException;

public final class UnifiedOptsTest {

  @Test
  public void opts_validation_uniqueKeys() {
    IllegalArgumentException iae =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                Opts.from(UnifiedOpts.generationMatch(1), UnifiedOpts.generationMatch(2))
                    .getRpcOptions());

    assertThat(iae).hasMessageThat().contains("GENERATION_MATCH");
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_unifiedOpts() throws Exception {
    validateFactoryMethodEnforceNonNull(UnifiedOpts.class, Opt.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_storage_blobGetOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Storage.BlobGetOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_storage_blobListOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Storage.BlobListOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_storage_blobSourceOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Storage.BlobSourceOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_storage_blobTargetOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Storage.BlobTargetOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_storage_blobWriteOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Storage.BlobWriteOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_bucket_blobTargetOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Bucket.BlobTargetOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_bucket_blobWriteOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Bucket.BlobWriteOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_blob_blobSourceOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Blob.BlobSourceOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_storage_bucketGetOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Storage.BucketGetOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_storage_bucketListOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Storage.BucketListOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_storage_bucketSourceOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Storage.BucketSourceOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_bucket_bucketSourceOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Bucket.BucketSourceOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_storage_bucketTargetOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Storage.BucketTargetOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_storage_createHmacKeyOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Storage.CreateHmacKeyOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_storage_deleteHmacKeyOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Storage.DeleteHmacKeyOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_storage_getHmacKeyOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Storage.GetHmacKeyOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_storage_listHmacKeyOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Storage.ListHmacKeysOption.class);
  }

  @Test
  public void validateFactoryMethodEnforceNonNull_storage_updateHmacKeyOption() throws Exception {
    validateFactoryMethodEnforceNonNull(Storage.UpdateHmacKeyOption.class);
  }

  @Test
  public void getHasher_selectsLastValue() {
    DefaultHasherSelector first = UnifiedOpts.defaultHasherSelector();
    Md5Match second = UnifiedOpts.md5Match("asdf");
    Crc32cMatch third = UnifiedOpts.crc32cMatch(3);
    Opts<HasherSelector> hasherOpts = Opts.from(first, second, third);

    HasherSelector actual = hasherOpts.getHasherSelector();
    assertThat(actual).isSameInstanceAs(third);
  }

  @Test
  public void hasher_md5Match_noop() {
    assertThat(UnifiedOpts.md5Match("xyz").getHasher()).isEqualTo(Hasher.noop());
  }

  @Test
  public void hasher_crc32cMatch_noop() {
    assertThat(UnifiedOpts.crc32cMatch(77).getHasher()).isEqualTo(Hasher.noop());
  }

  @Test
  public void transformTo() {
    SecretKey key =
        new SecretKey() {
          @Override
          public String getAlgorithm() {
            return "fake";
          }

          @Override
          public String getFormat() {
            return null;
          }

          @Override
          public byte[] getEncoded() {
            return "fake".getBytes(StandardCharsets.UTF_8);
          }
        };

    Opts<ObjectTargetOpt> targetOpts =
        Opts.from(
            // encryptionKey should project as a decryptionKey
            UnifiedOpts.encryptionKey(key),
            // userProject implements both target and source
            UnifiedOpts.userProject("user-project"),
            // contentType is not a source opt or a ProjectToSource opt, it should be excluded
            UnifiedOpts.setContentType("application/octet-stream"));
    Opts<ObjectSourceOpt> sourceOpts = targetOpts.transformTo(ObjectSourceOpt.class);

    Opts<ObjectSourceOpt> expected =
        Opts.from(UnifiedOpts.decryptionKey(key), UnifiedOpts.userProject("user-project"));
    assertThat(sourceOpts).isEqualTo(expected);
  }

  private static void validateFactoryMethodEnforceNonNull(Class<?> classToSearch) throws Exception {
    validateFactoryMethodEnforceNonNull(classToSearch, classToSearch);
  }

  private static void validateFactoryMethodEnforceNonNull(
      Class<?> classToSearch, Class<?> returnSuperType) throws Exception {
    List<Method> methods = findFactoryMethodsWithNullableParam(classToSearch, returnSuperType);
    assertThat(methods).isNotEmpty();
    List<Throwable> errors =
        methods.stream()
            .map(
                m -> {
                  try {
                    String msg =
                        String.format(
                            Locale.US, "Method %s did not throw expected NullPointerException", m);
                    try {
                      m.invoke(null, new Object[] {null});
                      return new AssertionError(msg);
                    } catch (InvocationTargetException e) {
                      if (e.getCause() instanceof NullPointerException) {
                        NullPointerException cause = (NullPointerException) e.getCause();
                        assertWithMessage(msg)
                            .that(cause)
                            .hasMessageThat()
                            .contains("must be non null");
                        return null;
                      }
                      return new AssertionError(msg, e);
                    } catch (Throwable t) {
                      return new AssertionError(msg, t);
                    }
                  } catch (Throwable e) {
                    return e;
                  }
                })
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    MultipleFailureException.assertEmpty(errors);
  }

  private static List<Method> findFactoryMethodsWithNullableParam(
      Class<?> classToSearch, Class<?> returnSuperType) {
    Method[] methods = classToSearch.getDeclaredMethods();
    return Arrays.stream(methods)
        .filter(
            m -> {
              boolean isStatic = Modifier.isStatic(m.getModifiers());
              boolean isOpt = returnSuperType.isAssignableFrom(m.getReturnType());
              boolean hasParam = m.getParameterCount() == 1;
              boolean isParamNonPrimitive = hasParam && !m.getParameterTypes()[0].isPrimitive();
              return isStatic && isOpt && hasParam && isParamNonPrimitive;
            })
        .collect(Collectors.toList());
  }
}
