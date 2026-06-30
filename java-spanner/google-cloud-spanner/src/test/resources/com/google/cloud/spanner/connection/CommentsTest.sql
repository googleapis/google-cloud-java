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

@EXPECT 'SELECT 1';
SELECT 1;
-- This is a single line comment
SELECT 1;
# This is a single line comment
SELECT 1;
/* This is a multi line comment on one line */
SELECT 1;
/* This
   is
   a
   multiline
   comment
*/
SELECT 1;
/* This
 * is
 * a
 * multiline
 * comment
 */
SELECT 1;
/** This is a javadoc style comment on one line*/
SELECT 1;
/** This
    is
    a
    javadoc
    style
    comment
    on
    multiple
    lines
*/
SELECT 1;
/** This
 *   is
 *   a
 *   javadoc
 *   style
 *   comment
 *   on
 *   multiple
 *   lines
 */
SELECT 1;

@EXPECT 'SELECT
1';
-- First comment
SELECT-- second comment
1;
# First comment
SELECT# second comment
1;
-- First comment
SELECT-- second comment
1--third comment
;
# First comment
SELECT# second comment
1#Third comment
;
/* First comment */
SELECT/* second comment */
1;
/* First comment */
SELECT/* second comment */
1/* Third comment */
;


@EXPECT 'SELECT 
1';
-- First comment
SELECT -- second comment
1 ;
# First comment
SELECT # second comment
1 ;
-- First comment
SELECT -- second comment
1 --third comment
;
# First comment
SELECT # second comment
1 #Third comment
;
/* First comment */
SELECT /* second comment */
1 ;
/* First comment */
SELECT /* second comment */
1 /* Third comment */
;

@EXPECT 'SELECT "TEST -- This is not a comment"';
SELECT "TEST -- This is not a comment";
-- This is a comment
SELECT "TEST -- This is not a comment";
-- This is a comment
SELECT "TEST -- This is not a comment" -- This is a comment;

@EXPECT 'SELECT "TEST # This is not a comment"';
SELECT "TEST # This is not a comment";
# This is a comment
SELECT "TEST # This is not a comment";
# This is a comment
SELECT "TEST # This is not a comment" # This is a comment;

@EXPECT 'SELECT "TEST /* This is not a comment */"';
SELECT "TEST /* This is not a comment */";
/* This is a comment */
SELECT "TEST /* This is not a comment */";
/* This is a comment */
SELECT "TEST /* This is not a comment */" /* This is a comment */;

@EXPECT 'SELECT 'TEST -- This is not a comment'';
SELECT 'TEST -- This is not a comment';
-- This is a comment
SELECT 'TEST -- This is not a comment';
-- This is a comment
SELECT 'TEST -- This is not a comment' -- This is a comment;

@EXPECT 'SELECT 'TEST # This is not a comment'';
SELECT 'TEST # This is not a comment';
# This is a comment
SELECT 'TEST # This is not a comment';
# This is a comment
SELECT 'TEST # This is not a comment' # This is a comment;

@EXPECT 'SELECT 'TEST /* This is not a comment */'';
SELECT 'TEST /* This is not a comment */';
/* This is a comment */
SELECT 'TEST /* This is not a comment */';
/* This is a comment */
SELECT 'TEST /* This is not a comment */' /* This is a comment */;

@EXPECT 'SELECT '''TEST
-- This is not a comment
'''';
SELECT '''TEST
-- This is not a comment
''';
-- This is a comment
SELECT '''TEST
-- This is not a comment
''';
-- This is a comment
SELECT '''TEST
-- This is not a comment
''' -- This is a comment;

@EXPECT 'SELECT '''TEST
# This is not a comment
'''';
SELECT '''TEST
# This is not a comment
''';
# This is a comment
SELECT '''TEST
# This is not a comment
''';
# This is a comment
SELECT '''TEST
# This is not a comment
''' # This is a comment;

@EXPECT 'SELECT '''TEST
/* This is not a comment */
'''';
SELECT '''TEST
/* This is not a comment */
''';
/* This is a comment */
SELECT '''TEST
/* This is not a comment */
''';
/* This is a comment */
SELECT '''TEST
/* This is not a comment */
''' /* This is a comment */;


@EXPECT 'SELECT """TEST
-- This is not a comment
"""';
SELECT """TEST
-- This is not a comment
""";
-- This is a comment
SELECT """TEST
-- This is not a comment
""";
-- This is a comment
SELECT """TEST
-- This is not a comment
""" -- This is a comment;

@EXPECT 'SELECT """TEST
# This is not a comment
"""';
SELECT """TEST
# This is not a comment
""";
# This is a comment
SELECT """TEST
# This is not a comment
""";
# This is a comment
SELECT """TEST
# This is not a comment
""" # This is a comment;

@EXPECT 'SELECT """TEST
/* This is not a comment */
"""';
SELECT """TEST
/* This is not a comment */
""";
/* This is a comment */
SELECT """TEST
/* This is not a comment */
""";
/* This is a comment */
SELECT """TEST
/* This is not a comment */
""" /* This is a comment */;



@EXPECT 'SELECT ```TEST
-- This is not a comment
```';
SELECT ```TEST
-- This is not a comment
```;
-- This is a comment
SELECT ```TEST
-- This is not a comment
```;
-- This is a comment
SELECT ```TEST
-- This is not a comment
``` -- This is a comment;

@EXPECT 'SELECT ```TEST
# This is not a comment
```';
SELECT ```TEST
# This is not a comment
```;
# This is a comment
SELECT ```TEST
# This is not a comment
```;
# This is a comment
SELECT ```TEST
# This is not a comment
``` # This is a comment;

@EXPECT 'SELECT ```TEST
/* This is not a comment */
```';
SELECT ```TEST
/* This is not a comment */
```;
/* This is a comment */
SELECT ```TEST
/* This is not a comment */
```;
/* This is a comment */
SELECT ```TEST
/* This is not a comment */
``` /* This is a comment */;


@EXPECT 'SELECT 1';
/* This is a comment /* this is still a comment */
SELECT 1;
/** This is a javadoc style comment /* this is still a comment */
SELECT 1;
/** This is a javadoc style comment /** this is still a comment */
SELECT 1;
/** This is a javadoc style comment /** this is still a comment **/
SELECT 1;
