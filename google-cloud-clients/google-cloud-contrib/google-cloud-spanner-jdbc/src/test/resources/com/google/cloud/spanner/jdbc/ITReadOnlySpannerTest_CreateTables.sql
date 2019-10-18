/*
 * Copyright 2019 Google LLC
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

SET READONLY = FALSE;
START BATCH DDL;

CREATE TABLE NUMBERS (NUMBER INT64 NOT NULL, NAME STRING(200) NOT NULL) PRIMARY KEY (NUMBER);
CREATE TABLE PRIME_NUMBERS (PRIME_NUMBER INT64 NOT NULL, BINARY_REPRESENTATION STRING(MAX) NOT NULL) PRIMARY KEY (PRIME_NUMBER);
RUN BATCH;
