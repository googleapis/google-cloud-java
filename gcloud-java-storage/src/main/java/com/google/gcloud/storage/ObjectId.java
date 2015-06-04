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

import java.net.URI;
import java.util.Objects;

/**
 * Identifier for a stored object.
 */
public class ObjectId {

    private final String bucketName;
    private final String objectName;
    private final URI uri;

    public ObjectId(String uri) {
        this(URI.create(uri));
    }

    /**
     * Constructs an ObjectId from a {@code gsutil} style URI.
     *
     * @param uri the object's URI
     */
    public ObjectId(URI uri) {
        Objects.requireNonNull(uri, "uri must not be null");
        this.uri = uri;
        if (uri.isAbsolute()) {
            if (!"gs".equals(uri.getScheme())) {
                throw new IllegalArgumentException("uri must use gs: scheme");
            }
            if (uri.getPath() == null || uri.getPath().length() <= 1) {
                throw new IllegalArgumentException("uri must have a path: " + uri);
            }
            bucketName = uri.getAuthority();
            objectName = uri.getPath().substring(1);
        } else {
            this.bucketName = null;
            this.objectName = uri.getPath();
        }
    }

    /**
     * Construct an absolute ObjectId from a bucket and object name.
     *
     * @param bucketName name of the bucket
     * @param objectName name of the object; must be a path relative to the bucket i.e. must not start with '/'
     */
    public ObjectId(String bucketName, String objectName) {
        Objects.requireNonNull(bucketName, "bucketName must not be null");
        if (bucketName.isEmpty()) {
            throw new IllegalArgumentException("bucketName must not be empty");
        }
        Objects.requireNonNull(objectName, "objectName must not be null");
        if (objectName.isEmpty()) {
            throw new IllegalArgumentException("objectName must not be empty");
        }
        if (objectName.charAt(0) == '/') {
            throw new IllegalArgumentException("objectName must be a relative path");
        }
        this.bucketName = bucketName;
        this.objectName = objectName;
        this.uri = URI.create("gs://" + bucketName + "/" + objectName);
    }

    /**
     * Returns the name of the bucket containing this object. May be null for object ids that solely define an
     * object name independent of bucket.
     *
     * @return the name of the bucket containing this object; may be null
     */
    public String getBucketName() {
        return bucketName;
    }

    /**
     * Returns the name of the object within the bucket.
     * @return the name of the object within the bucket
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * Returns the {@code gsutil} URI for this object.
     *
     * <p>If a bucketName is defined this will return an absolute URI of the form {@code gs://bucketName/objectName},
     * otherwise the objectName will be converted to a relative URI.
     *
     * @return the uri for this object
     */
    public URI toURI() {
        return uri;
    }

    /**
     * Returns this objects URI as a String.
     * @return this objects URI as a String
     */
    @Override
    public String toString() {
        return uri.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectId other = (ObjectId) o;
        return Objects.equals(bucketName, other.bucketName) &&
                Objects.equals(objectName, other.objectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bucketName, objectName);
    }
}
