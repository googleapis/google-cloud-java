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
import static org.junit.Assert.assertThrows;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.cloud.storage.Storage.PredefinedAcl;
import com.google.cloud.storage.UnifiedOpts.Headers;
import com.google.cloud.storage.UnifiedOpts.Mapper;
import com.google.cloud.storage.UnifiedOpts.NoOpObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.hash.Hashing;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.protobuf.ByteString;
import com.google.storage.v2.CommonObjectRequestParams;
import com.google.storage.v2.ComposeObjectRequest;
import com.google.storage.v2.CreateBucketRequest;
import com.google.storage.v2.DeleteBucketRequest;
import com.google.storage.v2.DeleteObjectRequest;
import com.google.storage.v2.GetBucketRequest;
import com.google.storage.v2.GetObjectRequest;
import com.google.storage.v2.ListBucketsRequest;
import com.google.storage.v2.ListObjectsRequest;
import com.google.storage.v2.Object;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.RewriteObjectRequest;
import com.google.storage.v2.UpdateBucketRequest;
import com.google.storage.v2.UpdateObjectRequest;
import com.google.storage.v2.WriteObjectRequest;
import com.google.storage.v2.WriteObjectSpec;
import java.security.SecureRandom;
import javax.crypto.spec.SecretKeySpec;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public final class UnifiedOptsGrpcTest {

  @RunWith(Enclosed.class)
  public static final class Opt {

    public static final class DecryptionKeyTest {
      @Test
      public void readObject() {
        CommonObjectRequestParams rand = randEncryption();
        SecretKeySpec k =
            new SecretKeySpec(
                rand.getEncryptionKeyBytes().toByteArray(), rand.getEncryptionAlgorithm());

        ReadObjectRequest expected =
            ReadObjectRequest.newBuilder().setCommonObjectRequestParams(rand).build();
        ReadObjectRequest actual =
            UnifiedOpts.decryptionKey(k).readObject().apply(ReadObjectRequest.newBuilder()).build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void getObject() {
        CommonObjectRequestParams rand = randEncryption();
        SecretKeySpec k =
            new SecretKeySpec(
                rand.getEncryptionKeyBytes().toByteArray(), rand.getEncryptionAlgorithm());

        GetObjectRequest expected =
            GetObjectRequest.newBuilder().setCommonObjectRequestParams(rand).build();
        GetObjectRequest actual =
            UnifiedOpts.decryptionKey(k).getObject().apply(GetObjectRequest.newBuilder()).build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void rewriteObject() {
        CommonObjectRequestParams rand = randEncryption();
        SecretKeySpec k =
            new SecretKeySpec(
                rand.getEncryptionKeyBytes().toByteArray(), rand.getEncryptionAlgorithm());

        RewriteObjectRequest expected =
            RewriteObjectRequest.newBuilder()
                .setCopySourceEncryptionAlgorithm(rand.getEncryptionAlgorithm())
                .setCopySourceEncryptionKeyBytes(rand.getEncryptionKeyBytes())
                .setCopySourceEncryptionKeySha256Bytes(rand.getEncryptionKeySha256Bytes())
                .build();
        RewriteObjectRequest actual =
            UnifiedOpts.decryptionKey(k)
                .rewriteObject()
                .apply(RewriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class DelimiterTest {
      @Test
      public void listObjects() {
        ListObjectsRequest expected = ListObjectsRequest.newBuilder().setDelimiter("|~|").build();

        ListObjectsRequest actual =
            UnifiedOpts.delimiter("|~|")
                .listObjects()
                .apply(ListObjectsRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class EncryptionKeyTest {
      @Test
      public void writeObject() {
        CommonObjectRequestParams rand = randEncryption();
        SecretKeySpec k =
            new SecretKeySpec(
                rand.getEncryptionKeyBytes().toByteArray(), rand.getEncryptionAlgorithm());

        WriteObjectRequest expected =
            WriteObjectRequest.newBuilder().setCommonObjectRequestParams(rand).build();
        WriteObjectRequest actual =
            UnifiedOpts.encryptionKey(k)
                .writeObject()
                .apply(WriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void updateObject() {
        CommonObjectRequestParams rand = randEncryption();
        SecretKeySpec k =
            new SecretKeySpec(
                rand.getEncryptionKeyBytes().toByteArray(), rand.getEncryptionAlgorithm());

        UpdateObjectRequest expected =
            UpdateObjectRequest.newBuilder().setCommonObjectRequestParams(rand).build();
        UpdateObjectRequest actual =
            UnifiedOpts.encryptionKey(k)
                .updateObject()
                .apply(UpdateObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void deleteObject() {
        CommonObjectRequestParams rand = randEncryption();
        SecretKeySpec k =
            new SecretKeySpec(
                rand.getEncryptionKeyBytes().toByteArray(), rand.getEncryptionAlgorithm());

        DeleteObjectRequest expected =
            DeleteObjectRequest.newBuilder().setCommonObjectRequestParams(rand).build();
        DeleteObjectRequest actual =
            UnifiedOpts.encryptionKey(k)
                .deleteObject()
                .apply(DeleteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void composeObject() {
        CommonObjectRequestParams rand = randEncryption();
        SecretKeySpec k =
            new SecretKeySpec(
                rand.getEncryptionKeyBytes().toByteArray(), rand.getEncryptionAlgorithm());

        ComposeObjectRequest expected =
            ComposeObjectRequest.newBuilder().setCommonObjectRequestParams(rand).build();
        ComposeObjectRequest actual =
            UnifiedOpts.encryptionKey(k)
                .composeObject()
                .apply(ComposeObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void rewriteObject() {
        CommonObjectRequestParams rand = randEncryption();
        SecretKeySpec k =
            new SecretKeySpec(
                rand.getEncryptionKeyBytes().toByteArray(), rand.getEncryptionAlgorithm());

        RewriteObjectRequest expected =
            RewriteObjectRequest.newBuilder().setCommonObjectRequestParams(rand).build();
        RewriteObjectRequest actual =
            UnifiedOpts.encryptionKey(k)
                .rewriteObject()
                .apply(RewriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class EndOffsetTest {
      @Test
      public void listObjects() {
        ListObjectsRequest expected =
            ListObjectsRequest.newBuilder().setLexicographicStart("start").build();

        ListObjectsRequest actual =
            UnifiedOpts.startOffset("start")
                .listObjects()
                .apply(ListObjectsRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class GenerationMatchTest {
      @Test
      public void writeObject() {
        WriteObjectRequest expected =
            WriteObjectRequest.newBuilder()
                .setWriteObjectSpec(WriteObjectSpec.newBuilder().setIfGenerationMatch(1L))
                .build();
        WriteObjectRequest actual =
            UnifiedOpts.generationMatch(1L)
                .writeObject()
                .apply(WriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void readObject() {
        ReadObjectRequest expected =
            ReadObjectRequest.newBuilder().setIfGenerationMatch(1L).build();
        ReadObjectRequest actual =
            UnifiedOpts.generationMatch(1L)
                .readObject()
                .apply(ReadObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void getObject() {
        GetObjectRequest expected = GetObjectRequest.newBuilder().setIfGenerationMatch(1L).build();
        GetObjectRequest actual =
            UnifiedOpts.generationMatch(1L)
                .getObject()
                .apply(GetObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void updateObject() {
        UpdateObjectRequest expected =
            UpdateObjectRequest.newBuilder().setIfGenerationMatch(1L).build();
        UpdateObjectRequest actual =
            UnifiedOpts.generationMatch(1L)
                .updateObject()
                .apply(UpdateObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void deleteObject() {
        DeleteObjectRequest expected =
            DeleteObjectRequest.newBuilder().setIfGenerationMatch(1L).build();
        DeleteObjectRequest actual =
            UnifiedOpts.generationMatch(1L)
                .deleteObject()
                .apply(DeleteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void composeObject() {
        ComposeObjectRequest expected =
            ComposeObjectRequest.newBuilder().setIfGenerationMatch(1L).build();
        ComposeObjectRequest actual =
            UnifiedOpts.generationMatch(1L)
                .composeObject()
                .apply(ComposeObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void rewriteObject() {
        RewriteObjectRequest expected =
            RewriteObjectRequest.newBuilder().setIfGenerationMatch(1L).build();
        RewriteObjectRequest actual =
            UnifiedOpts.generationMatch(1L)
                .rewriteObject()
                .apply(RewriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class GenerationNotMatchTest {
      @Test
      public void writeObject() {
        WriteObjectRequest expected =
            WriteObjectRequest.newBuilder()
                .setWriteObjectSpec(WriteObjectSpec.newBuilder().setIfGenerationNotMatch(1L))
                .build();
        WriteObjectRequest actual =
            UnifiedOpts.generationNotMatch(1L)
                .writeObject()
                .apply(WriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void readObject() {
        ReadObjectRequest expected =
            ReadObjectRequest.newBuilder().setIfGenerationNotMatch(1L).build();
        ReadObjectRequest actual =
            UnifiedOpts.generationNotMatch(1L)
                .readObject()
                .apply(ReadObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void getObject() {
        GetObjectRequest expected =
            GetObjectRequest.newBuilder().setIfGenerationNotMatch(1L).build();
        GetObjectRequest actual =
            UnifiedOpts.generationNotMatch(1L)
                .getObject()
                .apply(GetObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void updateObject() {
        UpdateObjectRequest expected =
            UpdateObjectRequest.newBuilder().setIfGenerationNotMatch(1L).build();
        UpdateObjectRequest actual =
            UnifiedOpts.generationNotMatch(1L)
                .updateObject()
                .apply(UpdateObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void deleteObject() {
        DeleteObjectRequest expected =
            DeleteObjectRequest.newBuilder().setIfGenerationNotMatch(1L).build();
        DeleteObjectRequest actual =
            UnifiedOpts.generationNotMatch(1L)
                .deleteObject()
                .apply(DeleteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void rewriteObject() {
        RewriteObjectRequest expected =
            RewriteObjectRequest.newBuilder().setIfGenerationNotMatch(1L).build();
        RewriteObjectRequest actual =
            UnifiedOpts.generationNotMatch(1L)
                .rewriteObject()
                .apply(RewriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class KmsKeyNameTest {
      @Test
      public void writeObject() {
        WriteObjectRequest expected =
            WriteObjectRequest.newBuilder()
                .setWriteObjectSpec(
                    WriteObjectSpec.newBuilder()
                        .setResource(Object.newBuilder().setKmsKey("key").build())
                        .build())
                .build();

        WriteObjectRequest actual =
            UnifiedOpts.kmsKeyName("key")
                .writeObject()
                .apply(WriteObjectRequest.newBuilder())
                .build();

        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void composeObject() {
        ComposeObjectRequest expected = ComposeObjectRequest.newBuilder().setKmsKey("key").build();

        ComposeObjectRequest actual =
            UnifiedOpts.kmsKeyName("key")
                .composeObject()
                .apply(ComposeObjectRequest.newBuilder())
                .build();

        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void rewriteObject() {
        RewriteObjectRequest expected =
            RewriteObjectRequest.newBuilder().setDestinationKmsKey("key").build();

        RewriteObjectRequest actual =
            UnifiedOpts.kmsKeyName("key")
                .rewriteObject()
                .apply(RewriteObjectRequest.newBuilder())
                .build();

        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class MetagenerationMatchTest {
      @Test
      public void writeObject() {
        WriteObjectRequest expected =
            WriteObjectRequest.newBuilder()
                .setWriteObjectSpec(WriteObjectSpec.newBuilder().setIfMetagenerationMatch(1L))
                .build();
        WriteObjectRequest actual =
            UnifiedOpts.metagenerationMatch(1L)
                .writeObject()
                .apply(WriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void readObject() {
        ReadObjectRequest expected =
            ReadObjectRequest.newBuilder().setIfMetagenerationMatch(1L).build();
        ReadObjectRequest actual =
            UnifiedOpts.metagenerationMatch(1L)
                .readObject()
                .apply(ReadObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void getObject() {
        GetObjectRequest expected =
            GetObjectRequest.newBuilder().setIfMetagenerationMatch(1L).build();
        GetObjectRequest actual =
            UnifiedOpts.metagenerationMatch(1L)
                .getObject()
                .apply(GetObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void updateObject() {
        UpdateObjectRequest expected =
            UpdateObjectRequest.newBuilder().setIfMetagenerationMatch(1L).build();
        UpdateObjectRequest actual =
            UnifiedOpts.metagenerationMatch(1L)
                .updateObject()
                .apply(UpdateObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void deleteObject() {
        DeleteObjectRequest expected =
            DeleteObjectRequest.newBuilder().setIfMetagenerationMatch(1L).build();
        DeleteObjectRequest actual =
            UnifiedOpts.metagenerationMatch(1L)
                .deleteObject()
                .apply(DeleteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void composeObject() {
        ComposeObjectRequest expected =
            ComposeObjectRequest.newBuilder().setIfMetagenerationMatch(1L).build();
        ComposeObjectRequest actual =
            UnifiedOpts.metagenerationMatch(1L)
                .composeObject()
                .apply(ComposeObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void rewriteObject() {
        RewriteObjectRequest expected =
            RewriteObjectRequest.newBuilder().setIfMetagenerationMatch(1L).build();
        RewriteObjectRequest actual =
            UnifiedOpts.metagenerationMatch(1L)
                .rewriteObject()
                .apply(RewriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void updateBucket() {
        UpdateBucketRequest expected =
            UpdateBucketRequest.newBuilder().setIfMetagenerationMatch(1L).build();
        UpdateBucketRequest actual =
            UnifiedOpts.metagenerationMatch(1L)
                .updateBucket()
                .apply(UpdateBucketRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void deleteBucket() {
        DeleteBucketRequest expected =
            DeleteBucketRequest.newBuilder().setIfMetagenerationMatch(1L).build();
        DeleteBucketRequest actual =
            UnifiedOpts.metagenerationMatch(1L)
                .deleteBucket()
                .apply(DeleteBucketRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void getBucket() {
        GetBucketRequest expected =
            GetBucketRequest.newBuilder().setIfMetagenerationMatch(1L).build();
        GetBucketRequest actual =
            UnifiedOpts.metagenerationMatch(1L)
                .getBucket()
                .apply(GetBucketRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class MetagenerationNotMatchTest {
      @Test
      public void writeObject() {
        WriteObjectRequest expected =
            WriteObjectRequest.newBuilder()
                .setWriteObjectSpec(WriteObjectSpec.newBuilder().setIfMetagenerationNotMatch(1L))
                .build();
        WriteObjectRequest actual =
            UnifiedOpts.metagenerationNotMatch(1L)
                .writeObject()
                .apply(WriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void readObject() {
        ReadObjectRequest expected =
            ReadObjectRequest.newBuilder().setIfMetagenerationNotMatch(1L).build();
        ReadObjectRequest actual =
            UnifiedOpts.metagenerationNotMatch(1L)
                .readObject()
                .apply(ReadObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void getObject() {
        GetObjectRequest expected =
            GetObjectRequest.newBuilder().setIfMetagenerationNotMatch(1L).build();
        GetObjectRequest actual =
            UnifiedOpts.metagenerationNotMatch(1L)
                .getObject()
                .apply(GetObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void updateObject() {
        UpdateObjectRequest expected =
            UpdateObjectRequest.newBuilder().setIfMetagenerationNotMatch(1L).build();
        UpdateObjectRequest actual =
            UnifiedOpts.metagenerationNotMatch(1L)
                .updateObject()
                .apply(UpdateObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void deleteObject() {
        DeleteObjectRequest expected =
            DeleteObjectRequest.newBuilder().setIfMetagenerationNotMatch(1L).build();
        DeleteObjectRequest actual =
            UnifiedOpts.metagenerationNotMatch(1L)
                .deleteObject()
                .apply(DeleteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void rewriteObject() {
        RewriteObjectRequest expected =
            RewriteObjectRequest.newBuilder().setIfMetagenerationNotMatch(1L).build();
        RewriteObjectRequest actual =
            UnifiedOpts.metagenerationNotMatch(1L)
                .rewriteObject()
                .apply(RewriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void updateBucket() {
        UpdateBucketRequest expected =
            UpdateBucketRequest.newBuilder().setIfMetagenerationNotMatch(1L).build();
        UpdateBucketRequest actual =
            UnifiedOpts.metagenerationNotMatch(1L)
                .updateBucket()
                .apply(UpdateBucketRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void deleteBucket() {
        DeleteBucketRequest expected =
            DeleteBucketRequest.newBuilder().setIfMetagenerationNotMatch(1L).build();
        DeleteBucketRequest actual =
            UnifiedOpts.metagenerationNotMatch(1L)
                .deleteBucket()
                .apply(DeleteBucketRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void getBucket() {
        GetBucketRequest expected =
            GetBucketRequest.newBuilder().setIfMetagenerationNotMatch(1L).build();
        GetBucketRequest actual =
            UnifiedOpts.metagenerationNotMatch(1L)
                .getBucket()
                .apply(GetBucketRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class PageSizeTest {
      @Test
      public void listBuckets() {
        ListBucketsRequest expected = ListBucketsRequest.newBuilder().setPageSize(5).build();

        ListBucketsRequest actual =
            UnifiedOpts.pageSize(5).listBuckets().apply(ListBucketsRequest.newBuilder()).build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void listObjects() {
        ListObjectsRequest expected = ListObjectsRequest.newBuilder().setPageSize(5).build();

        ListObjectsRequest actual =
            UnifiedOpts.pageSize(5).listObjects().apply(ListObjectsRequest.newBuilder()).build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class PageTokenTest {
      @Test
      public void listBuckets() {
        ListBucketsRequest expected =
            ListBucketsRequest.newBuilder().setPageToken("pageToken").build();

        ListBucketsRequest actual =
            UnifiedOpts.pageToken("pageToken")
                .listBuckets()
                .apply(ListBucketsRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void listObjects() {
        ListObjectsRequest expected =
            ListObjectsRequest.newBuilder().setPageToken("pageToken").build();

        ListObjectsRequest actual =
            UnifiedOpts.pageToken("pageToken")
                .listObjects()
                .apply(ListObjectsRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class PredefinedAclTest {
      @Test
      public void writeObject() {
        WriteObjectRequest expected =
            WriteObjectRequest.newBuilder()
                .setWriteObjectSpec(WriteObjectSpec.newBuilder().setPredefinedAcl("private"))
                .build();
        WriteObjectRequest actual =
            UnifiedOpts.predefinedAcl(PredefinedAcl.PRIVATE)
                .writeObject()
                .apply(WriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void updateObject() {
        UpdateObjectRequest expected =
            UpdateObjectRequest.newBuilder().setPredefinedAcl("private").build();
        UpdateObjectRequest actual =
            UnifiedOpts.predefinedAcl(PredefinedAcl.PRIVATE)
                .updateObject()
                .apply(UpdateObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void composeObject() {
        ComposeObjectRequest expected =
            ComposeObjectRequest.newBuilder().setDestinationPredefinedAcl("private").build();
        ComposeObjectRequest actual =
            UnifiedOpts.predefinedAcl(PredefinedAcl.PRIVATE)
                .composeObject()
                .apply(ComposeObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void rewriteObject() {
        RewriteObjectRequest expected =
            RewriteObjectRequest.newBuilder().setDestinationPredefinedAcl("private").build();
        RewriteObjectRequest actual =
            UnifiedOpts.predefinedAcl(PredefinedAcl.PRIVATE)
                .rewriteObject()
                .apply(RewriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void updateBucket() {
        UpdateBucketRequest expected =
            UpdateBucketRequest.newBuilder().setPredefinedAcl("private").build();
        UpdateBucketRequest actual =
            UnifiedOpts.predefinedAcl(PredefinedAcl.PRIVATE)
                .updateBucket()
                .apply(UpdateBucketRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void createBucket() {
        CreateBucketRequest expected =
            CreateBucketRequest.newBuilder().setPredefinedAcl("private").build();
        CreateBucketRequest actual =
            UnifiedOpts.predefinedAcl(PredefinedAcl.PRIVATE)
                .createBucket()
                .apply(CreateBucketRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class PredefinedDefaultObjectAclTest {
      @Test
      public void createBucket() {
        CreateBucketRequest expected =
            CreateBucketRequest.newBuilder().setPredefinedDefaultObjectAcl("private").build();
        CreateBucketRequest actual =
            UnifiedOpts.predefinedDefaultObjectAcl(PredefinedAcl.PRIVATE)
                .createBucket()
                .apply(CreateBucketRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void updateBucket() {
        UpdateBucketRequest expected =
            UpdateBucketRequest.newBuilder().setPredefinedDefaultObjectAcl("private").build();
        UpdateBucketRequest actual =
            UnifiedOpts.predefinedDefaultObjectAcl(PredefinedAcl.PRIVATE)
                .updateBucket()
                .apply(UpdateBucketRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class PrefixTest {
      @Test
      public void listBuckets() {
        ListBucketsRequest expected = ListBucketsRequest.newBuilder().setPrefix("prefix").build();

        ListBucketsRequest actual =
            UnifiedOpts.prefix("prefix")
                .listBuckets()
                .apply(ListBucketsRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void listObjects() {
        ListObjectsRequest expected = ListObjectsRequest.newBuilder().setPrefix("prefix").build();

        ListObjectsRequest actual =
            UnifiedOpts.prefix("prefix")
                .listObjects()
                .apply(ListObjectsRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class SourceGenerationMatchTest {
      @Test
      public void rewriteObject() {
        RewriteObjectRequest expected =
            RewriteObjectRequest.newBuilder().setIfSourceGenerationMatch(1L).build();
        RewriteObjectRequest actual =
            UnifiedOpts.generationMatch(1L)
                .asSource()
                .rewriteObject()
                .apply(RewriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class SourceGenerationNotMatchTest {
      @Test
      public void rewriteObject() {
        RewriteObjectRequest expected =
            RewriteObjectRequest.newBuilder().setIfSourceGenerationNotMatch(1L).build();
        RewriteObjectRequest actual =
            UnifiedOpts.generationNotMatch(1L)
                .asSource()
                .rewriteObject()
                .apply(RewriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class SourceMetagenerationMatchTest {
      @Test
      public void rewriteObject() {
        RewriteObjectRequest expected =
            RewriteObjectRequest.newBuilder().setIfSourceMetagenerationMatch(1L).build();
        RewriteObjectRequest actual =
            UnifiedOpts.metagenerationMatch(1L)
                .asSource()
                .rewriteObject()
                .apply(RewriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class SourceMetagenerationNotMatchTest {
      @Test
      public void rewriteObject() {
        RewriteObjectRequest expected =
            RewriteObjectRequest.newBuilder().setIfSourceMetagenerationNotMatch(1L).build();
        RewriteObjectRequest actual =
            UnifiedOpts.metagenerationNotMatch(1L)
                .asSource()
                .rewriteObject()
                .apply(RewriteObjectRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class RequestedPolicyVersionTest {
      @Test
      public void getIamPolicy() {
        GetIamPolicyRequest expected =
            GetIamPolicyRequest.newBuilder()
                .setOptions(GetPolicyOptions.newBuilder().setRequestedPolicyVersion(3).build())
                .build();
        GetIamPolicyRequest actual =
            UnifiedOpts.requestedPolicyVersion(3)
                .getIamPolicy()
                .apply(GetIamPolicyRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class SetContentTypeTest {
      @Test
      public void writeObject() {
        WriteObjectRequest expected =
            WriteObjectRequest.newBuilder()
                .setWriteObjectSpec(
                    WriteObjectSpec.newBuilder()
                        .setResource(Object.newBuilder().setContentType("text/plain").build())
                        .build())
                .build();

        WriteObjectRequest actual =
            UnifiedOpts.setContentType("text/plain")
                .writeObject()
                .apply(WriteObjectRequest.newBuilder())
                .build();

        assertThat(actual).isEqualTo(expected);
      }

      @Test
      public void updateObject() {
        UpdateObjectRequest expected =
            UpdateObjectRequest.newBuilder()
                .setObject(Object.newBuilder().setContentType("text/plain").build())
                .build();

        UpdateObjectRequest actual =
            UnifiedOpts.setContentType("text/plain")
                .updateObject()
                .apply(UpdateObjectRequest.newBuilder())
                .build();

        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class StartOffsetTest {
      @Test
      public void listObjects() {
        ListObjectsRequest expected =
            ListObjectsRequest.newBuilder().setLexicographicStart("start").build();

        ListObjectsRequest actual =
            UnifiedOpts.startOffset("start")
                .listObjects()
                .apply(ListObjectsRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class UserProjectTest {
      @Test
      public void grpcCallContext() {
        GrpcCallContext expected =
            GrpcCallContext.createDefault()
                .withExtraHeaders(
                    ImmutableMap.of("X-Goog-User-Project", ImmutableList.of("user-project")));
        GrpcCallContext actual =
            UnifiedOpts.userProject("user-project")
                .getGrpcMetadataMapper()
                .apply(GrpcCallContext.createDefault());

        assertThat(actual.getExtraHeaders()).isEqualTo(expected.getExtraHeaders());
        assertThat(actual).isEqualTo(expected);
      }
    }

    public static final class VersionsFilterTest {
      @Test
      public void listObjects() {
        ListObjectsRequest expected = ListObjectsRequest.newBuilder().setVersions(true).build();

        ListObjectsRequest actual =
            UnifiedOpts.versionsFilter(true)
                .listObjects()
                .apply(ListObjectsRequest.newBuilder())
                .build();
        assertThat(actual).isEqualTo(expected);
      }
    }
  }

  @RunWith(Enclosed.class)
  public static final class Extractor {

    public static final class Crc32cMatchExtractorTest {

      @Test
      public void extractFromBlobInfo_nonNull() {
        BlobInfo info = BlobInfo.newBuilder("b", "o").setCrc32c("crc32c").build();
        ObjectTargetOpt opt = UnifiedOpts.crc32cMatchExtractor().extractFromBlobInfo(info);
        assertThat(opt).isEqualTo(UnifiedOpts.crc32cMatch("crc32c"));
      }

      @Test
      public void extractFromBlobInfo_null() {
        BlobInfo info = BlobInfo.newBuilder("b", "o").build();
        ObjectTargetOpt opt = UnifiedOpts.crc32cMatchExtractor().extractFromBlobInfo(info);
        assertThat(opt).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
      }

      @Test
      public void extractFromBlobId_noop() {
        ObjectTargetOpt opt = UnifiedOpts.crc32cMatchExtractor().extractFromBlobId(null);
        assertThat(opt).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
      }
    }

    public static final class DetectContentTypeTest {

      @Test
      public void hasExtension() {
        BlobInfo info1 = BlobInfo.newBuilder("bucket", "obj.txt").build();
        ObjectTargetOpt opt = UnifiedOpts.detectContentType().extractFromBlobInfo(info1);

        assertThat(opt).isEqualTo(UnifiedOpts.setContentType("text/plain"));
      }

      @Test
      public void noopIfAlreadySpecified() {
        BlobInfo info1 =
            BlobInfo.newBuilder("bucket", "obj.txt").setContentType("text/plain").build();
        ObjectTargetOpt opt = UnifiedOpts.detectContentType().extractFromBlobInfo(info1);

        assertThat(opt).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
      }

      @Test
      public void baseCaseIsApplicationOctetStream() {
        BlobInfo info1 = BlobInfo.newBuilder("bucket", "obj").build();
        ObjectTargetOpt opt = UnifiedOpts.detectContentType().extractFromBlobInfo(info1);

        assertThat(opt).isEqualTo(UnifiedOpts.setContentType("application/octet-stream"));
      }
    }

    public static final class GenerationMatchExtractorTest {
      @Test
      public void extractFromBlobInfo_nonNull() {
        BlobInfo info = BlobInfo.newBuilder("b", "o", 3L).build();
        ObjectTargetOpt opt = UnifiedOpts.generationMatchExtractor().extractFromBlobInfo(info);
        assertThat(opt).isEqualTo(UnifiedOpts.generationMatch(3L));
      }

      @Test
      public void extractFromBlobInfo_null() {
        BlobInfo info = BlobInfo.newBuilder("b", "o").build();
        assertThat(
                assertThrows(
                    IllegalArgumentException.class,
                    () -> UnifiedOpts.generationMatchExtractor().extractFromBlobInfo(info)))
            .hasMessageThat()
            .contains("ifGenerationMatch");
      }

      @Test
      public void extractFromBlobId_nonNull() {
        BlobId id = BlobId.of("b", "o", 3L);
        ObjectTargetOpt opt = UnifiedOpts.generationMatchExtractor().extractFromBlobId(id);
        assertThat(opt).isEqualTo(UnifiedOpts.generationMatch(3L));
      }

      @Test
      public void extractFromBlobId_null() {
        BlobId id = BlobId.of("b", "o");
        assertThat(
                assertThrows(
                    IllegalArgumentException.class,
                    () -> UnifiedOpts.generationMatchExtractor().extractFromBlobId(id)))
            .hasMessageThat()
            .contains("ifGenerationMatch");
      }
    }

    public static final class GenerationNotMatchExtractorTest {
      @Test
      public void extractFromBlobInfo_nonNull() {
        BlobInfo info = BlobInfo.newBuilder("b", "o", 3L).build();
        ObjectTargetOpt opt = UnifiedOpts.generationNotMatchExtractor().extractFromBlobInfo(info);
        assertThat(opt).isEqualTo(UnifiedOpts.generationNotMatch(3L));
      }

      @Test
      public void extractFromBlobInfo_null() {
        BlobInfo info = BlobInfo.newBuilder("b", "o").build();
        assertThat(
                assertThrows(
                    IllegalArgumentException.class,
                    () -> UnifiedOpts.generationNotMatchExtractor().extractFromBlobInfo(info)))
            .hasMessageThat()
            .contains("ifGenerationNotMatch");
      }

      @Test
      public void extractFromBlobId_nonNull() {
        BlobId id = BlobId.of("b", "o", 3L);
        ObjectTargetOpt opt = UnifiedOpts.generationNotMatchExtractor().extractFromBlobId(id);
        assertThat(opt).isEqualTo(UnifiedOpts.generationNotMatch(3L));
      }

      @Test
      public void extractFromBlobId_null() {
        BlobId id = BlobId.of("b", "o");
        assertThat(
                assertThrows(
                    IllegalArgumentException.class,
                    () -> UnifiedOpts.generationNotMatchExtractor().extractFromBlobId(id)))
            .hasMessageThat()
            .contains("ifGenerationNotMatch");
      }
    }

    public static final class Md5MatchExtractorTest {

      @Test
      public void extractFromBlobInfo_nonNull() {
        BlobInfo info = BlobInfo.newBuilder("b", "o").setMd5("md5").build();
        ObjectTargetOpt opt = UnifiedOpts.md5MatchExtractor().extractFromBlobInfo(info);
        assertThat(opt).isEqualTo(UnifiedOpts.md5Match("md5"));
      }

      @Test
      public void extractFromBlobInfo_null() {
        BlobInfo info = BlobInfo.newBuilder("b", "o").build();
        ObjectTargetOpt opt = UnifiedOpts.md5MatchExtractor().extractFromBlobInfo(info);
        assertThat(opt).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
      }

      @Test
      public void extractFromBlobId_noop() {
        ObjectTargetOpt opt = UnifiedOpts.md5MatchExtractor().extractFromBlobId(null);
        assertThat(opt).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
      }
    }

    public static final class MetagenerationMatchExtractorTest {
      @Test
      public void extractFromBlobInfo_nonNull() {
        BlobInfo info = BlobInfo.newBuilder("b", "o").setMetageneration(1L).build();
        ObjectTargetOpt opt = UnifiedOpts.metagenerationMatchExtractor().extractFromBlobInfo(info);
        assertThat(opt).isEqualTo(UnifiedOpts.metagenerationMatch(1L));
      }

      @Test
      public void extractFromBlobInfo_null() {
        BlobInfo info = BlobInfo.newBuilder("b", "o").build();
        assertThat(
                assertThrows(
                    IllegalArgumentException.class,
                    () -> UnifiedOpts.metagenerationMatchExtractor().extractFromBlobInfo(info)))
            .hasMessageThat()
            .contains("ifMetagenerationMatch");
      }

      @Test
      public void extractFromBlobId_noop() {
        ObjectTargetOpt opt = UnifiedOpts.metagenerationMatchExtractor().extractFromBlobId(null);
        assertThat(opt).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
      }

      @Test
      public void extractFromBucketInfo_nonNull() {
        BucketInfo info = BucketInfo.newBuilder("b").setMetageneration(1L).build();
        ObjectTargetOpt opt =
            UnifiedOpts.metagenerationMatchExtractor().extractFromBucketInfo(info);
        assertThat(opt).isEqualTo(UnifiedOpts.metagenerationMatch(1L));
      }

      @Test
      public void extractFromBucketInfo_null() {
        BucketInfo info = BucketInfo.newBuilder("b").build();
        assertThat(
                assertThrows(
                    IllegalArgumentException.class,
                    () -> UnifiedOpts.metagenerationMatchExtractor().extractFromBucketInfo(info)))
            .hasMessageThat()
            .contains("ifMetagenerationMatch");
      }
    }

    public static final class MetagenerationNotMatchExtractorTest {
      @Test
      public void extractFromBlobInfo_nonNull() {
        BlobInfo info = BlobInfo.newBuilder("b", "o").setMetageneration(1L).build();
        ObjectTargetOpt opt =
            UnifiedOpts.metagenerationNotMatchExtractor().extractFromBlobInfo(info);
        assertThat(opt).isEqualTo(UnifiedOpts.metagenerationNotMatch(1L));
      }

      @Test
      public void extractFromBlobInfo_null() {
        BlobInfo info = BlobInfo.newBuilder("b", "o").build();
        assertThat(
                assertThrows(
                    IllegalArgumentException.class,
                    () -> UnifiedOpts.metagenerationNotMatchExtractor().extractFromBlobInfo(info)))
            .hasMessageThat()
            .contains("ifMetagenerationNotMatch");
      }

      @Test
      public void extractFromBlobId_noop() {
        ObjectTargetOpt opt = UnifiedOpts.metagenerationNotMatchExtractor().extractFromBlobId(null);
        assertThat(opt).isEqualTo(NoOpObjectTargetOpt.INSTANCE);
      }

      @Test
      public void extractFromBucketInfo_nonNull() {
        BucketInfo info = BucketInfo.newBuilder("b").setMetageneration(1L).build();
        ObjectTargetOpt opt =
            UnifiedOpts.metagenerationNotMatchExtractor().extractFromBucketInfo(info);
        assertThat(opt).isEqualTo(UnifiedOpts.metagenerationNotMatch(1L));
      }

      @Test
      public void extractFromBucketInfo_null() {
        BucketInfo info = BucketInfo.newBuilder("b").build();
        assertThat(
                assertThrows(
                    IllegalArgumentException.class,
                    () ->
                        UnifiedOpts.metagenerationNotMatchExtractor().extractFromBucketInfo(info)))
            .hasMessageThat()
            .contains("ifMetagenerationNotMatch");
      }
    }
  }

  public static final class NoOpObjectTargetOptTest {
    @Test
    public void grpcMetadataMapper() {
      GrpcCallContext ctx1 = GrpcCallContext.createDefault();
      GrpcCallContext ctx2 = NoOpObjectTargetOpt.INSTANCE.getGrpcMetadataMapper().apply(ctx1);
      assertThat(ctx2).isEqualTo(ctx1);
      assertThat(ctx2).isSameInstanceAs(ctx1);
    }

    @Test
    public void blobInfo() {
      BlobInfo.Builder b1 = BlobInfo.newBuilder("b", "o");
      // "checkpoint" our builder to allow for comparison
      BlobInfo expected = b1.build();
      BlobInfo.Builder b2 = NoOpObjectTargetOpt.INSTANCE.blobInfo().apply(b1);
      assertThat(b2.build()).isEqualTo(expected);
      assertThat(b2).isSameInstanceAs(b1);
    }
  }

  public static final class SourceAndTargetOpt {
    @Test
    public void rewriteObject_decryptAndEncrypt() {
      CommonObjectRequestParams source = randEncryption();
      CommonObjectRequestParams dest = randEncryption();
      SecretKeySpec keySource =
          new SecretKeySpec(
              source.getEncryptionKeyBytes().toByteArray(), source.getEncryptionAlgorithm());
      SecretKeySpec keyDest =
          new SecretKeySpec(
              dest.getEncryptionKeyBytes().toByteArray(), dest.getEncryptionAlgorithm());

      RewriteObjectRequest expected =
          RewriteObjectRequest.newBuilder()
              .setCopySourceEncryptionAlgorithm(source.getEncryptionAlgorithm())
              .setCopySourceEncryptionKeyBytes(source.getEncryptionKeyBytes())
              .setCopySourceEncryptionKeySha256Bytes(source.getEncryptionKeySha256Bytes())
              .setCommonObjectRequestParams(dest)
              .build();
      Opts<UnifiedOpts.Opt> opts =
          Opts.from(UnifiedOpts.decryptionKey(keySource), UnifiedOpts.encryptionKey(keyDest));
      Mapper<RewriteObjectRequest.Builder> mapper = opts.rewriteObjectsRequest();

      RewriteObjectRequest actual = mapper.apply(RewriteObjectRequest.newBuilder()).build();
      assertThat(actual).isEqualTo(expected);
    }
  }

  @SuppressWarnings("unchecked")
  public static final class HeadersOptTest {

    @Test
    public void duplicateHeaderValues_firstWins_grpc() {
      Opts<Headers> o1 = Opts.from(UnifiedOpts.extraHeaders(ImmutableMap.of("k", "1")));
      Opts<Headers> o2 = Opts.from(UnifiedOpts.extraHeaders(ImmutableMap.of("k", "2")));

      Mapper<GrpcCallContext> mapper = o1.grpcMetadataMapper().andThen(o2.grpcMetadataMapper());

      GrpcCallContext grpcCallContext = mapper.apply(GrpcCallContext.createDefault());
      assertThat(grpcCallContext.getExtraHeaders())
          .containsExactlyEntriesIn(ImmutableMap.of("k", ImmutableList.of("1")));
    }

    @Test
    public void duplicateHeaderValues_firstWins_rpcOptions() {
      Opts<Headers> o1 =
          Opts.from(
              UnifiedOpts.extraHeaders(ImmutableMap.of("k", "1", "a", "A")),
              UnifiedOpts.extraHeaders(ImmutableMap.of("k", "2", "b", "B")));

      ImmutableMap<StorageRpc.Option, ?> rpcOptions = o1.getRpcOptions();

      ImmutableMap<String, String> extraHeaders =
          (ImmutableMap<String, String>) rpcOptions.get(StorageRpc.Option.EXTRA_HEADERS);
      assertThat(extraHeaders).isNotNull();
      assertThat(extraHeaders)
          .containsExactlyEntriesIn(ImmutableMap.of("k", "1", "a", "A", "b", "B"));
    }

    @Test
    public void duplicateHeaderValues_firstWins_keyComparisonIsCaseInsensitive() {
      Opts<Headers> o1 =
          Opts.from(
              UnifiedOpts.extraHeaders(ImmutableMap.of("K", "1", "a", "A")),
              UnifiedOpts.extraHeaders(ImmutableMap.of("k", "2", "b", "B")));

      ImmutableMap<StorageRpc.Option, ?> rpcOptions = o1.getRpcOptions();

      ImmutableMap<String, String> extraHeaders =
          (ImmutableMap<String, String>) rpcOptions.get(StorageRpc.Option.EXTRA_HEADERS);
      assertThat(extraHeaders).isNotNull();
      assertThat(extraHeaders)
          .containsExactlyEntriesIn(ImmutableMap.of("k", "1", "a", "A", "b", "B"));
    }

    @Test
    public void headersOnBlocklistResultInIllegalArgumentException() {
      IllegalArgumentException expected =
          assertThrows(
              IllegalArgumentException.class,
              () ->
                  UnifiedOpts.extraHeaders(
                      ImmutableMap.<String, String>builder()
                          .put("Accept-Encoding", "a")
                          .put("Cache-Control", "a")
                          .put("Connection", "a")
                          .put("Content-ID", "a")
                          .put("Content-Length", "a")
                          .put("Content-Range", "a")
                          .put("Content-Transfer-Encoding", "a")
                          .put("Content-Type", "a")
                          .put("Date", "a")
                          .put("ETag", "a")
                          .put("If-Match", "a")
                          .put("If-None-Match", "a")
                          .put("Keep-Alive", "a")
                          .put("Range", "a")
                          .put("TE", "a")
                          .put("Trailer", "a")
                          .put("Transfer-Encoding", "a")
                          .put("User-Agent", "a")
                          .put("X-Goog-Api-Client", "a")
                          .put("X-Goog-Content-Length-Range", "a")
                          .put("X-Goog-Copy-Source-Encryption-Algorithm", "a")
                          .put("X-Goog-Copy-Source-Encryption-Key", "a")
                          .put("X-Goog-Copy-Source-Encryption-Key-Sha256", "a")
                          .put("X-Goog-Encryption-Algorithm", "a")
                          .put("X-Goog-Encryption-Key", "a")
                          .put("X-Goog-Encryption-Key-Sha256", "a")
                          .put("X-Goog-Meta-A", "a")
                          .put("X-Goog-Request-Params", "a")
                          .put("X-Goog-User-Project", "a")
                          .put("X-HTTP-Method-Override", "a")
                          .put("X-Upload-Content-Length", "a")
                          .put("X-Upload-Content-Type", "a")
                          .put("A", "a")
                          .build()));
      assertThat(expected)
          .hasMessageThat()
          .contains(
              "[accept-encoding, cache-control, connection, content-id, content-length,"
                  + " content-range, content-transfer-encoding, content-type, date, etag, if-match,"
                  + " if-none-match, keep-alive, range, te, trailer, transfer-encoding, user-agent,"
                  + " x-goog-api-client, x-goog-content-length-range,"
                  + " x-goog-copy-source-encryption-algorithm, x-goog-copy-source-encryption-key,"
                  + " x-goog-copy-source-encryption-key-sha256, x-goog-encryption-algorithm,"
                  + " x-goog-encryption-key, x-goog-encryption-key-sha256, x-goog-meta-a,"
                  + " x-goog-request-params, x-goog-user-project, x-http-method-override,"
                  + " x-upload-content-length, x-upload-content-type]");
    }
  }

  private static CommonObjectRequestParams randEncryption() {
    byte[] bytes = new byte[32];
    new SecureRandom().nextBytes(bytes);
    return CommonObjectRequestParams.newBuilder()
        .setEncryptionAlgorithm("AES256")
        .setEncryptionKeyBytes(ByteString.copyFrom(bytes))
        .setEncryptionKeySha256Bytes(
            ByteString.copyFrom(Hashing.sha256().hashBytes(bytes).asBytes()))
        .build();
  }
}
