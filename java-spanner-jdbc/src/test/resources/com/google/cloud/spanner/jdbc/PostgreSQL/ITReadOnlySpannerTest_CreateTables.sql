/*
 * Copyright 2021 Google LLC
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

NEW_CONNECTION;

SET SPANNER.READONLY = FALSE;
START BATCH DDL;

CREATE TABLE NUMBERS (NUMBER BIGINT PRIMARY KEY, NAME VARCHAR(200) NOT NULL);
CREATE TABLE PRIME_NUMBERS (PRIME_NUMBER BIGINT PRIMARY KEY, BINARY_REPRESENTATION VARCHAR NOT NULL);
RUN BATCH;
