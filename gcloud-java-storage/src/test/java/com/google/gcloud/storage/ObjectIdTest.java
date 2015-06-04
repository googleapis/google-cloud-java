/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS-IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.google.gcloud.storage;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.net.URI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ObjectIdTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createWithBucketAndObjectName() {
        ObjectId id = new ObjectId("bucket", "path/to/object.txt");
        assertEquals("bucket", id.getBucketName());
        assertEquals("path/to/object.txt", id.getObjectName());
        assertEquals("gs://bucket/path/to/object.txt", id.toString());
        assertEquals(URI.create("gs://bucket/path/to/object.txt"), id.toURI());
    }

    @Test
    public void createFromRelativeURI() {
        ObjectId id = new ObjectId("path/to/object.txt");
        assertNull(id.getBucketName());
        assertEquals("path/to/object.txt", id.getObjectName());
        assertEquals("path/to/object.txt", id.toString());
        assertEquals(URI.create("path/to/object.txt"), id.toURI());
    }

    @Test
    public void createFromAbsoluteURI() {
        ObjectId id = new ObjectId("gs://bucket/path/to/object.txt");
        assertEquals("bucket", id.getBucketName());
        assertEquals("path/to/object.txt", id.getObjectName());
        assertEquals("gs://bucket/path/to/object.txt", id.toString());
        assertEquals(URI.create("gs://bucket/path/to/object.txt"), id.toURI());
    }

    @Test
    public void nullBucketNameNotAllowed() {
        thrown.expect(NullPointerException.class);
        new ObjectId(null, "object");
    }

    @Test
    public void emptyBucketNameNotAllowed() {
        thrown.expect(IllegalArgumentException.class);
        new ObjectId("", "object");
    }

    @Test
    public void nullObjectNameNotAllowed() {
        thrown.expect(NullPointerException.class);
        new ObjectId("bucket", null);
    }

    @Test
    public void emptyObjectNameNotAllowed() {
        thrown.expect(IllegalArgumentException.class);
        new ObjectId("bucket", "");
    }

    @Test
    public void slashObjectNameNotAllowed() {
        thrown.expect(IllegalArgumentException.class);
        new ObjectId("bucket", "/");
    }

    @Test
    public void checkConsistentHashing() {
        ObjectId id1 = new ObjectId("bucket", "object");
        ObjectId id2 = new ObjectId("gs://bucket/object");
        assertTrue(id1.equals(id2));
        assertTrue(id1.hashCode() == id2.hashCode());
    }
}
