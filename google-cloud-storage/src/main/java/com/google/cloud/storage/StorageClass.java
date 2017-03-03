/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

/**
 * String constants for the names of the storage classes.
 */
public class StorageClass {
  /**
   * Name for the multi-regional storage class.
   */
  public static final String MULTI_REGIONAL = "MULTI_REGIONAL";
  
  /**
   * Name for the regional storage class.
   */
  public static final String REGIONAL = "REGIONAL";
  
  /**
   * Name for the Nearline storage class.
   */
  public static final String NEARLINE = "NEARLINE";
  
  /**
   * Name for the Codeline storage class.
   */
  public static final String COLDLINE = "COLDLINE";
  
  /**
   * Name for the standard storage class.
   */
  public static final String STANDARD = "STANDARD";
}
