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

@EXPECT 'SELECT 1';
SELECT 1;
-- This is a single line comment
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
-- First comment
SELECT-- second comment
      1--third comment
;
@EXPECT 'SELECT
    1';
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
-- First comment
SELECT -- second comment
       1 --third comment
;
@EXPECT 'SELECT 
    1';
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

           @EXPECT 'SELECT 'TEST /* This is not a comment */'';
SELECT 'TEST /* This is not a comment */';
/* This is a comment */
SELECT 'TEST /* This is not a comment */';
/* This is a comment */
SELECT 'TEST /* This is not a comment */' /* This is a comment */;

@EXPECT 'SELECT $$TEST
-- This is not a comment
$$';
SELECT $$TEST
-- This is not a comment
$$;
-- This is a comment
SELECT $$TEST
-- This is not a comment
$$;
-- This is a comment
SELECT $$TEST
-- This is not a comment
$$ -- This is a comment;

           @EXPECT 'SELECT $$TEST
/* This is not a comment */
$$';
SELECT $$TEST
/* This is not a comment */
$$;
/* This is a comment */
SELECT $$TEST
/* This is not a comment */
$$;
/* This is a comment */
SELECT $$TEST
/* This is not a comment */
$$ /* This is a comment */;

@EXPECT 'SELECT 1';
/* This is a comment /* This is an embedded comment */ This is still a comment */
SELECT 1;
/** This is a javadoc style comment /* This is an embedded comment */ This is still a comment */
SELECT 1;
/** This is a javadoc style comment /** This is an embedded comment */ This is still a comment */
SELECT 1;
/** This is a javadoc style comment /** This is an embedded comment **/ This is still a comment **/
SELECT 1;
/* multiline comment
 * with nesting: /* nested block comment */
 */
SELECT 1;

@EXPECT 'SELECT U&"d\0061t\+000061" FROM FOO';
SELECT U&"d\0061t\+000061" FROM FOO;
/* This is a comment /* U&"d\0061t\+000061" */ This is still a comment */
SELECT U&"d\0061t\+000061" FROM FOO;
SELECT U&"d\0061t\+000061" /* This is a comment /* U&"d\0061t\+000061" */ This is still a comment */FROM FOO;

@EXPECT 'SELECT U&"d\0061t\+000061" 
FROM FOO';
SELECT U&"d\0061t\+000061" -- U&"d\0061t\+000061" == data */ This is still a comment */
FROM FOO;

@EXPECT 'SELECT 'foo'
'bar'
SELECT 'foo' -- This is allowed in PostgreSQL
'bar';
