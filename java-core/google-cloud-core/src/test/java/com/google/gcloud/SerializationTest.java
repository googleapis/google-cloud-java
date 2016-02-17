package com.google.gcloud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.IamPolicy.Acl;
import com.google.gcloud.IamPolicy.Identity;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationTest {

  private static final Identity IDENTITY = Identity.user("abc@gmail.com");
  private static final Acl ACL = Acl.of("viewer", ImmutableList.of(IDENTITY));
  private static final IamPolicy POLICY =
      IamPolicy.builder().acls(ImmutableList.of(ACL)).etag("etag").version(1).build();

  @Test
  public void testModelAndRequests() throws Exception {
    Serializable[] objects = {IDENTITY, ACL, POLICY};
    for (Serializable obj : objects) {
      Object copy = serializeAndDeserialize(obj);
      assertEquals(obj, obj);
      assertEquals(obj, copy);
      assertNotSame(obj, copy);
      assertEquals(copy, copy);
    }
  }

  @SuppressWarnings("unchecked")
  private <T> T serializeAndDeserialize(T obj) throws IOException, ClassNotFoundException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
      output.writeObject(obj);
    }
    try (ObjectInputStream input =
        new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()))) {
      return (T) input.readObject();
    }
  }
}
