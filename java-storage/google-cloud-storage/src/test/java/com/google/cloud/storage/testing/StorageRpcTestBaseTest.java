/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.storage.testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.HmacKey;
import com.google.api.services.storage.model.HmacKeyMetadata;
import com.google.api.services.storage.model.Notification;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.Policy;
import com.google.api.services.storage.model.ServiceAccount;
import com.google.api.services.storage.model.StorageObject;
import com.google.api.services.storage.model.TestIamPermissionsResponse;
import com.google.cloud.Tuple;
import com.google.cloud.storage.spi.v1.RpcBatch;
import com.google.cloud.storage.spi.v1.StorageRpc;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StorageRpcTestBaseTest {

  private Callable rpc;

  private static final StorageRpc STORAGE_RPC = new StorageRpcTestBase();
  private static final Map<StorageRpc.Option, Object> OPTIONS = new HashMap<>();
  private static final Bucket BUCKET = new Bucket().setName("fake-bucket");
  private static final byte[] BYTES = {0, 1, 2, 3, 4, 5, 6, 7};
  private static final StorageObject OBJECT =
      new StorageObject().setName("object name").setBucket("bucket name");

  @Before
  public void setUp() {
    rpc = null;
  }

  @After
  public void tearDown() throws Exception {
    assertNotNull(rpc);
    try {
      rpc.call();
      fail("UnsupportedOperationException expected");
    } catch (UnsupportedOperationException e) {
      // expected
    }
  }

  @Test
  public void testCreateBucket() {
    rpc =
        new Callable<Bucket>() {
          @Override
          public Bucket call() {
            return STORAGE_RPC.create(BUCKET, OPTIONS);
          }
        };
  }

  @Test
  public void testCreateObject() {
    rpc =
        new Callable<StorageObject>() {
          @Override
          public StorageObject call() {
            return STORAGE_RPC.create(OBJECT, new ByteArrayInputStream(BYTES), OPTIONS);
          }
        };
  }

  @Test
  public void testList() {
    rpc =
        new Callable<Tuple<String, Iterable<Bucket>>>() {
          @Override
          public Tuple<String, Iterable<Bucket>> call() {
            return STORAGE_RPC.list(OPTIONS);
          }
        };
  }

  @Test
  public void testListBucket() {
    rpc =
        new Callable<Tuple<String, Iterable<StorageObject>>>() {
          @Override
          public Tuple<String, Iterable<StorageObject>> call() {
            return STORAGE_RPC.list(BUCKET.getName(), OPTIONS);
          }
        };
  }

  @Test
  public void testGetBucket() {
    rpc =
        new Callable<Bucket>() {
          @Override
          public Bucket call() {
            return STORAGE_RPC.get(BUCKET, OPTIONS);
          }
        };
  }

  @Test
  public void testGetObject() {
    rpc =
        new Callable<StorageObject>() {
          @Override
          public StorageObject call() {
            return STORAGE_RPC.get(OBJECT, OPTIONS);
          }
        };
  }

  @Test
  public void testPatchBucket() {
    rpc =
        new Callable<Bucket>() {
          @Override
          public Bucket call() {
            return STORAGE_RPC.patch(BUCKET, OPTIONS);
          }
        };
  }

  @Test
  public void testPatchObject() {
    rpc =
        new Callable<StorageObject>() {
          @Override
          public StorageObject call() {
            return STORAGE_RPC.patch(OBJECT, OPTIONS);
          }
        };
  }

  @Test
  public void testDeleteBucket() {
    rpc =
        new Callable<Boolean>() {
          @Override
          public Boolean call() {
            return STORAGE_RPC.delete(BUCKET, OPTIONS);
          }
        };
  }

  @Test
  public void testDeleteObject() {
    rpc =
        new Callable<Boolean>() {
          @Override
          public Boolean call() {
            return STORAGE_RPC.delete(OBJECT, OPTIONS);
          }
        };
  }

  @Test
  public void testCreateBatch() {
    rpc =
        new Callable<RpcBatch>() {
          @Override
          public RpcBatch call() {
            return STORAGE_RPC.createBatch();
          }
        };
  }

  @Test
  public void testCompose() {
    rpc =
        new Callable<StorageObject>() {
          @Override
          public StorageObject call() {
            return STORAGE_RPC.compose(null, OBJECT, OPTIONS);
          }
        };
  }

  @Test
  public void testLoad() {
    rpc =
        new Callable<byte[]>() {
          @Override
          public byte[] call() {
            return STORAGE_RPC.load(OBJECT, OPTIONS);
          }
        };
  }

  @Test
  public void testReadBytes() {
    rpc =
        new Callable<Tuple<String, byte[]>>() {
          @Override
          public Tuple<String, byte[]> call() {
            return STORAGE_RPC.read(OBJECT, OPTIONS, 0, 0);
          }
        };
  }

  @Test
  public void testReadOutputStream() {
    rpc =
        new Callable<Long>() {
          @Override
          public Long call() {
            return STORAGE_RPC.read(OBJECT, OPTIONS, 0, new ByteArrayOutputStream(100));
          }
        };
  }

  @Test
  public void testOpenObject() {
    rpc =
        new Callable<String>() {
          @Override
          public String call() {
            return STORAGE_RPC.open(OBJECT, OPTIONS);
          }
        };
  }

  @Test
  public void testOpenSignedURL() {
    rpc =
        new Callable<String>() {
          @Override
          public String call() {
            return STORAGE_RPC.open("signedURL");
          }
        };
  }

  @Test
  public void testWrite() {
    rpc =
        new Callable<Void>() {
          @Override
          public Void call() {
            STORAGE_RPC.write("uploadId", new byte[10], 1, 2L, 3, false);
            return null;
          }
        };
  }

  @Test
  public void testOpenRewrite() {
    rpc =
        new Callable<StorageRpc.RewriteResponse>() {
          @Override
          public StorageRpc.RewriteResponse call() {
            return STORAGE_RPC.openRewrite(null);
          }
        };
  }

  @Test
  public void testContinueRewrite() {
    rpc =
        new Callable<StorageRpc.RewriteResponse>() {
          @Override
          public StorageRpc.RewriteResponse call() {
            return STORAGE_RPC.continueRewrite(null);
          }
        };
  }

  @Test
  public void testGetAclBucket() {
    rpc =
        new Callable<BucketAccessControl>() {
          @Override
          public BucketAccessControl call() {
            return STORAGE_RPC.getAcl("bucket", "entity", OPTIONS);
          }
        };
  }

  @Test
  public void testGetAclObject() {
    rpc =
        new Callable<ObjectAccessControl>() {
          @Override
          public ObjectAccessControl call() {
            return STORAGE_RPC.getAcl("bucket", "object", 1L, "entity");
          }
        };
  }

  @Test
  public void testDeleteAclBucket() {
    rpc =
        new Callable<Boolean>() {
          @Override
          public Boolean call() {
            return STORAGE_RPC.deleteAcl("bucketName", "entity", OPTIONS);
          }
        };
  }

  @Test
  public void testDeleteAclObject() {
    rpc =
        new Callable<Boolean>() {
          @Override
          public Boolean call() {
            return STORAGE_RPC.deleteAcl("bucketName", "object", 0L, "entity");
          }
        };
  }

  @Test
  public void testCreateAclBucket() {
    rpc =
        new Callable<BucketAccessControl>() {
          @Override
          public BucketAccessControl call() {
            return STORAGE_RPC.createAcl(null, OPTIONS);
          }
        };
  }

  @Test
  public void testCreateAclObject() {
    rpc =
        new Callable<ObjectAccessControl>() {
          @Override
          public ObjectAccessControl call() {
            return STORAGE_RPC.createAcl(null);
          }
        };
  }

  @Test
  public void testPatchAclBucket() {
    rpc =
        new Callable<ObjectAccessControl>() {
          @Override
          public ObjectAccessControl call() {
            return STORAGE_RPC.createAcl(null);
          }
        };
  }

  @Test
  public void testPatchAclObject() {
    rpc =
        new Callable<ObjectAccessControl>() {
          @Override
          public ObjectAccessControl call() {
            return STORAGE_RPC.patchAcl(null);
          }
        };
  }

  @Test
  public void testListAclsBucket() {
    rpc =
        new Callable<List<BucketAccessControl>>() {
          @Override
          public List<BucketAccessControl> call() {
            return STORAGE_RPC.listAcls("BUCKET_NAME", OPTIONS);
          }
        };
  }

  @Test
  public void testListAclsObject() {
    rpc =
        new Callable<List<ObjectAccessControl>>() {
          @Override
          public List<ObjectAccessControl> call() {
            return STORAGE_RPC.listAcls("BUCKET_NAME", "OBJECT_NAME", 100L);
          }
        };
  }

  @Test
  public void testCreateHmacKey() {
    rpc =
        new Callable<HmacKey>() {
          @Override
          public HmacKey call() {
            return STORAGE_RPC.createHmacKey("account", OPTIONS);
          }
        };
  }

  @Test
  public void testListHmacKeys() {
    rpc =
        new Callable<Tuple<String, Iterable<HmacKeyMetadata>>>() {
          @Override
          public Tuple<String, Iterable<HmacKeyMetadata>> call() {
            return STORAGE_RPC.listHmacKeys(OPTIONS);
          }
        };
  }

  @Test
  public void testUpdateHmacKey() {
    rpc =
        new Callable<HmacKeyMetadata>() {
          @Override
          public HmacKeyMetadata call() {
            return STORAGE_RPC.updateHmacKey(null, OPTIONS);
          }
        };
  }

  @Test
  public void testGetHmacKey() {
    rpc =
        new Callable<HmacKeyMetadata>() {
          @Override
          public HmacKeyMetadata call() {
            return STORAGE_RPC.getHmacKey("account", OPTIONS);
          }
        };
  }

  @Test
  public void testDeleteHmacKey() {
    rpc =
        new Callable<Void>() {
          @Override
          public Void call() {
            STORAGE_RPC.deleteHmacKey(null, OPTIONS);
            return null;
          }
        };
  }

  @Test
  public void testGetDefaultAcl() {
    rpc =
        new Callable<ObjectAccessControl>() {
          @Override
          public ObjectAccessControl call() {
            return STORAGE_RPC.getDefaultAcl("bucket", "entity");
          }
        };
  }

  @Test
  public void testDeleteDefaultAcl() {
    rpc =
        new Callable<Boolean>() {
          @Override
          public Boolean call() {
            return STORAGE_RPC.deleteDefaultAcl("bucket", "entity");
          }
        };
  }

  @Test
  public void testCreateDefaultAcl() {
    rpc =
        new Callable<ObjectAccessControl>() {
          @Override
          public ObjectAccessControl call() {
            return STORAGE_RPC.createDefaultAcl(null);
          }
        };
  }

  @Test
  public void testPatchDefaultAcl() {
    rpc =
        new Callable<ObjectAccessControl>() {
          @Override
          public ObjectAccessControl call() {
            return STORAGE_RPC.patchDefaultAcl(null);
          }
        };
  }

  @Test
  public void testListDefaultAcls() {
    rpc =
        new Callable<List<ObjectAccessControl>>() {
          @Override
          public List<ObjectAccessControl> call() {
            return STORAGE_RPC.listDefaultAcls("bucket");
          }
        };
  }

  @Test
  public void testGetIamPolicy() {
    rpc =
        new Callable<Policy>() {
          @Override
          public Policy call() {
            return STORAGE_RPC.getIamPolicy("bucket", OPTIONS);
          }
        };
  }

  @Test
  public void testSetIamPolicy() {
    rpc =
        new Callable<Policy>() {
          @Override
          public Policy call() {
            return STORAGE_RPC.setIamPolicy("bucket", null, OPTIONS);
          }
        };
  }

  @Test
  public void testTestIamPermissions() {
    rpc =
        new Callable<TestIamPermissionsResponse>() {
          @Override
          public TestIamPermissionsResponse call() {
            return STORAGE_RPC.testIamPermissions("bucket", null, OPTIONS);
          }
        };
  }

  @Test
  public void testDeleteNotification() {
    rpc =
        new Callable<Boolean>() {
          @Override
          public Boolean call() {
            return STORAGE_RPC.deleteNotification("bucket", "entity");
          }
        };
  }

  @Test
  public void testListNotifications() {
    rpc =
        new Callable<List<Notification>>() {
          @Override
          public List<Notification> call() {
            return STORAGE_RPC.listNotifications("bucket");
          }
        };
  }

  @Test
  public void testCreateNotification() {
    rpc =
        new Callable<Notification>() {
          @Override
          public Notification call() {
            return STORAGE_RPC.createNotification("bucket", null);
          }
        };
  }

  @Test
  public void testGetNotification() {
    rpc =
        new Callable<Notification>() {
          @Override
          public Notification call() {
            return STORAGE_RPC.getNotification("bucket", "notification");
          }
        };
  }

  @Test
  public void testLockRetentionPolicy() {
    rpc =
        new Callable<Bucket>() {
          @Override
          public Bucket call() {
            return STORAGE_RPC.lockRetentionPolicy(BUCKET, OPTIONS);
          }
        };
  }

  @Test
  public void testGetServiceAccount() {
    rpc =
        new Callable<ServiceAccount>() {
          @Override
          public ServiceAccount call() {
            return STORAGE_RPC.getServiceAccount("project");
          }
        };
  }
}
