NEW_CONNECTION;
show variable autocommit;
NEW_CONNECTION;
SHOW VARIABLE AUTOCOMMIT;
NEW_CONNECTION;
show variable autocommit;
NEW_CONNECTION;
   show variable autocommit;
NEW_CONNECTION;
			show variable autocommit;
NEW_CONNECTION;



show variable autocommit;
NEW_CONNECTION;
show variable autocommit  ;
NEW_CONNECTION;
show variable autocommit		;
NEW_CONNECTION;
show variable autocommit

;
NEW_CONNECTION;
show   variable   autocommit;
NEW_CONNECTION;
show	variable	autocommit;
NEW_CONNECTION;
show
variable
autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable autocommit;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-autocommit;
NEW_CONNECTION;
show variable readonly;
NEW_CONNECTION;
SHOW VARIABLE READONLY;
NEW_CONNECTION;
show variable readonly;
NEW_CONNECTION;
   show variable readonly;
NEW_CONNECTION;
			show variable readonly;
NEW_CONNECTION;



show variable readonly;
NEW_CONNECTION;
show variable readonly  ;
NEW_CONNECTION;
show variable readonly		;
NEW_CONNECTION;
show variable readonly

;
NEW_CONNECTION;
show   variable   readonly;
NEW_CONNECTION;
show	variable	readonly;
NEW_CONNECTION;
show
variable
readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable readonly;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable readonly/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-readonly;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
SHOW VARIABLE RETRY_ABORTS_INTERNALLY;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
   show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
			show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;



show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
show variable retry_aborts_internally  ;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
show variable retry_aborts_internally		;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
show variable retry_aborts_internally

;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
show   variable   retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
show	variable	retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
show
variable
retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally bar;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally%;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally_;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally&;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally$;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally@;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally!;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally*;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally(;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally);
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally-;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally+;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally-#;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally/;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally\;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally?;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally-/;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally/#;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable retry_aborts_internally;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable retry_aborts_internally/-;
NEW_CONNECTION;
set readonly=false;
set autocommit=false;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-retry_aborts_internally;
NEW_CONNECTION;
show variable autocommit_dml_mode;
NEW_CONNECTION;
SHOW VARIABLE AUTOCOMMIT_DML_MODE;
NEW_CONNECTION;
show variable autocommit_dml_mode;
NEW_CONNECTION;
   show variable autocommit_dml_mode;
NEW_CONNECTION;
			show variable autocommit_dml_mode;
NEW_CONNECTION;



show variable autocommit_dml_mode;
NEW_CONNECTION;
show variable autocommit_dml_mode  ;
NEW_CONNECTION;
show variable autocommit_dml_mode		;
NEW_CONNECTION;
show variable autocommit_dml_mode

;
NEW_CONNECTION;
show   variable   autocommit_dml_mode;
NEW_CONNECTION;
show	variable	autocommit_dml_mode;
NEW_CONNECTION;
show
variable
autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable autocommit_dml_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable autocommit_dml_mode/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-autocommit_dml_mode;
NEW_CONNECTION;
show variable statement_timeout;
NEW_CONNECTION;
SHOW VARIABLE STATEMENT_TIMEOUT;
NEW_CONNECTION;
show variable statement_timeout;
NEW_CONNECTION;
   show variable statement_timeout;
NEW_CONNECTION;
			show variable statement_timeout;
NEW_CONNECTION;



show variable statement_timeout;
NEW_CONNECTION;
show variable statement_timeout  ;
NEW_CONNECTION;
show variable statement_timeout		;
NEW_CONNECTION;
show variable statement_timeout

;
NEW_CONNECTION;
show   variable   statement_timeout;
NEW_CONNECTION;
show	variable	statement_timeout;
NEW_CONNECTION;
show
variable
statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable statement_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_timeout/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-statement_timeout;
NEW_CONNECTION;
show variable transaction_timeout;
NEW_CONNECTION;
SHOW VARIABLE TRANSACTION_TIMEOUT;
NEW_CONNECTION;
show variable transaction_timeout;
NEW_CONNECTION;
   show variable transaction_timeout;
NEW_CONNECTION;
			show variable transaction_timeout;
NEW_CONNECTION;



show variable transaction_timeout;
NEW_CONNECTION;
show variable transaction_timeout  ;
NEW_CONNECTION;
show variable transaction_timeout		;
NEW_CONNECTION;
show variable transaction_timeout

;
NEW_CONNECTION;
show   variable   transaction_timeout;
NEW_CONNECTION;
show	variable	transaction_timeout;
NEW_CONNECTION;
show
variable
transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable transaction_timeout;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_timeout/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-transaction_timeout;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
SHOW VARIABLE READ_TIMESTAMP;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
   show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
			show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;



show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
show variable read_timestamp  ;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
show variable read_timestamp		;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
show variable read_timestamp

;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
show   variable   read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
show	variable	read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
show
variable
read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp bar;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp%;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp_;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp&;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp$;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp@;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp!;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp*;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp(;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp);
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp-;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp+;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp-#;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp/;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp\;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp?;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp-/;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp/#;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable read_timestamp;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_timestamp/-;
NEW_CONNECTION;
set readonly = true;
SELECT 1 AS TEST;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-read_timestamp;
NEW_CONNECTION;
update foo set bar=1;
show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
SHOW VARIABLE COMMIT_TIMESTAMP;
NEW_CONNECTION;
update foo set bar=1;
show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
   show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
			show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;



show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
show variable commit_timestamp  ;
NEW_CONNECTION;
update foo set bar=1;
show variable commit_timestamp		;
NEW_CONNECTION;
update foo set bar=1;
show variable commit_timestamp

;
NEW_CONNECTION;
update foo set bar=1;
show   variable   commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
show	variable	commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
show
variable
commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp bar;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp%;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp_;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp&;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp$;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp@;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp!;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp*;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp(;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp);
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp-;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp+;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp-#;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp/;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp\;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp?;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp-/;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp/#;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable commit_timestamp;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_timestamp/-;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-commit_timestamp;
NEW_CONNECTION;
show variable read_only_staleness;
NEW_CONNECTION;
SHOW VARIABLE READ_ONLY_STALENESS;
NEW_CONNECTION;
show variable read_only_staleness;
NEW_CONNECTION;
   show variable read_only_staleness;
NEW_CONNECTION;
			show variable read_only_staleness;
NEW_CONNECTION;



show variable read_only_staleness;
NEW_CONNECTION;
show variable read_only_staleness  ;
NEW_CONNECTION;
show variable read_only_staleness		;
NEW_CONNECTION;
show variable read_only_staleness

;
NEW_CONNECTION;
show   variable   read_only_staleness;
NEW_CONNECTION;
show	variable	read_only_staleness;
NEW_CONNECTION;
show
variable
read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable read_only_staleness;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_only_staleness/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-read_only_staleness;
NEW_CONNECTION;
show variable directed_read;
NEW_CONNECTION;
SHOW VARIABLE DIRECTED_READ;
NEW_CONNECTION;
show variable directed_read;
NEW_CONNECTION;
   show variable directed_read;
NEW_CONNECTION;
			show variable directed_read;
NEW_CONNECTION;



show variable directed_read;
NEW_CONNECTION;
show variable directed_read  ;
NEW_CONNECTION;
show variable directed_read		;
NEW_CONNECTION;
show variable directed_read

;
NEW_CONNECTION;
show   variable   directed_read;
NEW_CONNECTION;
show	variable	directed_read;
NEW_CONNECTION;
show
variable
directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable directed_read;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable directed_read/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-directed_read;
NEW_CONNECTION;
show variable optimizer_version;
NEW_CONNECTION;
SHOW VARIABLE OPTIMIZER_VERSION;
NEW_CONNECTION;
show variable optimizer_version;
NEW_CONNECTION;
   show variable optimizer_version;
NEW_CONNECTION;
			show variable optimizer_version;
NEW_CONNECTION;



show variable optimizer_version;
NEW_CONNECTION;
show variable optimizer_version  ;
NEW_CONNECTION;
show variable optimizer_version		;
NEW_CONNECTION;
show variable optimizer_version

;
NEW_CONNECTION;
show   variable   optimizer_version;
NEW_CONNECTION;
show	variable	optimizer_version;
NEW_CONNECTION;
show
variable
optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable optimizer_version;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_version/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-optimizer_version;
NEW_CONNECTION;
show variable optimizer_statistics_package;
NEW_CONNECTION;
SHOW VARIABLE OPTIMIZER_STATISTICS_PACKAGE;
NEW_CONNECTION;
show variable optimizer_statistics_package;
NEW_CONNECTION;
   show variable optimizer_statistics_package;
NEW_CONNECTION;
			show variable optimizer_statistics_package;
NEW_CONNECTION;



show variable optimizer_statistics_package;
NEW_CONNECTION;
show variable optimizer_statistics_package  ;
NEW_CONNECTION;
show variable optimizer_statistics_package		;
NEW_CONNECTION;
show variable optimizer_statistics_package

;
NEW_CONNECTION;
show   variable   optimizer_statistics_package;
NEW_CONNECTION;
show	variable	optimizer_statistics_package;
NEW_CONNECTION;
show
variable
optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable optimizer_statistics_package;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable optimizer_statistics_package/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-optimizer_statistics_package;
NEW_CONNECTION;
show variable return_commit_stats;
NEW_CONNECTION;
SHOW VARIABLE RETURN_COMMIT_STATS;
NEW_CONNECTION;
show variable return_commit_stats;
NEW_CONNECTION;
   show variable return_commit_stats;
NEW_CONNECTION;
			show variable return_commit_stats;
NEW_CONNECTION;



show variable return_commit_stats;
NEW_CONNECTION;
show variable return_commit_stats  ;
NEW_CONNECTION;
show variable return_commit_stats		;
NEW_CONNECTION;
show variable return_commit_stats

;
NEW_CONNECTION;
show   variable   return_commit_stats;
NEW_CONNECTION;
show	variable	return_commit_stats;
NEW_CONNECTION;
show
variable
return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable return_commit_stats;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable return_commit_stats/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-return_commit_stats;
NEW_CONNECTION;
show variable max_commit_delay;
NEW_CONNECTION;
SHOW VARIABLE MAX_COMMIT_DELAY;
NEW_CONNECTION;
show variable max_commit_delay;
NEW_CONNECTION;
   show variable max_commit_delay;
NEW_CONNECTION;
			show variable max_commit_delay;
NEW_CONNECTION;



show variable max_commit_delay;
NEW_CONNECTION;
show variable max_commit_delay  ;
NEW_CONNECTION;
show variable max_commit_delay		;
NEW_CONNECTION;
show variable max_commit_delay

;
NEW_CONNECTION;
show   variable   max_commit_delay;
NEW_CONNECTION;
show	variable	max_commit_delay;
NEW_CONNECTION;
show
variable
max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable max_commit_delay;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_commit_delay/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-max_commit_delay;
NEW_CONNECTION;
update foo set bar=1;
show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
SHOW VARIABLE COMMIT_RESPONSE;
NEW_CONNECTION;
update foo set bar=1;
show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
   show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
			show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;



show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
show variable commit_response  ;
NEW_CONNECTION;
update foo set bar=1;
show variable commit_response		;
NEW_CONNECTION;
update foo set bar=1;
show variable commit_response

;
NEW_CONNECTION;
update foo set bar=1;
show   variable   commit_response;
NEW_CONNECTION;
update foo set bar=1;
show	variable	commit_response;
NEW_CONNECTION;
update foo set bar=1;
show
variable
commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response bar;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response%;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response_;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response&;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response$;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response@;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response!;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response*;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response(;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response);
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response-;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response+;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response-#;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response/;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response\;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response?;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response-/;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response/#;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable commit_response;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable commit_response/-;
NEW_CONNECTION;
update foo set bar=1;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-commit_response;
NEW_CONNECTION;
show variable statement_tag;
NEW_CONNECTION;
SHOW VARIABLE STATEMENT_TAG;
NEW_CONNECTION;
show variable statement_tag;
NEW_CONNECTION;
   show variable statement_tag;
NEW_CONNECTION;
			show variable statement_tag;
NEW_CONNECTION;



show variable statement_tag;
NEW_CONNECTION;
show variable statement_tag  ;
NEW_CONNECTION;
show variable statement_tag		;
NEW_CONNECTION;
show variable statement_tag

;
NEW_CONNECTION;
show   variable   statement_tag;
NEW_CONNECTION;
show	variable	statement_tag;
NEW_CONNECTION;
show
variable
statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable statement_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable statement_tag/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-statement_tag;
NEW_CONNECTION;
show variable transaction_tag;
NEW_CONNECTION;
SHOW VARIABLE TRANSACTION_TAG;
NEW_CONNECTION;
show variable transaction_tag;
NEW_CONNECTION;
   show variable transaction_tag;
NEW_CONNECTION;
			show variable transaction_tag;
NEW_CONNECTION;



show variable transaction_tag;
NEW_CONNECTION;
show variable transaction_tag  ;
NEW_CONNECTION;
show variable transaction_tag		;
NEW_CONNECTION;
show variable transaction_tag

;
NEW_CONNECTION;
show   variable   transaction_tag;
NEW_CONNECTION;
show	variable	transaction_tag;
NEW_CONNECTION;
show
variable
transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable transaction_tag;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable transaction_tag/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-transaction_tag;
NEW_CONNECTION;
show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
SHOW VARIABLE EXCLUDE_TXN_FROM_CHANGE_STREAMS;
NEW_CONNECTION;
show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
   show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
			show variable exclude_txn_from_change_streams;
NEW_CONNECTION;



show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
show variable exclude_txn_from_change_streams  ;
NEW_CONNECTION;
show variable exclude_txn_from_change_streams		;
NEW_CONNECTION;
show variable exclude_txn_from_change_streams

;
NEW_CONNECTION;
show   variable   exclude_txn_from_change_streams;
NEW_CONNECTION;
show	variable	exclude_txn_from_change_streams;
NEW_CONNECTION;
show
variable
exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable exclude_txn_from_change_streams;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable exclude_txn_from_change_streams/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-exclude_txn_from_change_streams;
NEW_CONNECTION;
show variable rpc_priority;
NEW_CONNECTION;
SHOW VARIABLE RPC_PRIORITY;
NEW_CONNECTION;
show variable rpc_priority;
NEW_CONNECTION;
   show variable rpc_priority;
NEW_CONNECTION;
			show variable rpc_priority;
NEW_CONNECTION;



show variable rpc_priority;
NEW_CONNECTION;
show variable rpc_priority  ;
NEW_CONNECTION;
show variable rpc_priority		;
NEW_CONNECTION;
show variable rpc_priority

;
NEW_CONNECTION;
show   variable   rpc_priority;
NEW_CONNECTION;
show	variable	rpc_priority;
NEW_CONNECTION;
show
variable
rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable rpc_priority;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable rpc_priority/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-rpc_priority;
NEW_CONNECTION;
show variable savepoint_support;
NEW_CONNECTION;
SHOW VARIABLE SAVEPOINT_SUPPORT;
NEW_CONNECTION;
show variable savepoint_support;
NEW_CONNECTION;
   show variable savepoint_support;
NEW_CONNECTION;
			show variable savepoint_support;
NEW_CONNECTION;



show variable savepoint_support;
NEW_CONNECTION;
show variable savepoint_support  ;
NEW_CONNECTION;
show variable savepoint_support		;
NEW_CONNECTION;
show variable savepoint_support

;
NEW_CONNECTION;
show   variable   savepoint_support;
NEW_CONNECTION;
show	variable	savepoint_support;
NEW_CONNECTION;
show
variable
savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable savepoint_support;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable savepoint_support/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-savepoint_support;
NEW_CONNECTION;
show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
SHOW VARIABLE DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE;
NEW_CONNECTION;
show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
   show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
			show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;



show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
show variable delay_transaction_start_until_first_write  ;
NEW_CONNECTION;
show variable delay_transaction_start_until_first_write		;
NEW_CONNECTION;
show variable delay_transaction_start_until_first_write

;
NEW_CONNECTION;
show   variable   delay_transaction_start_until_first_write;
NEW_CONNECTION;
show	variable	delay_transaction_start_until_first_write;
NEW_CONNECTION;
show
variable
delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable delay_transaction_start_until_first_write;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable delay_transaction_start_until_first_write/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-delay_transaction_start_until_first_write;
NEW_CONNECTION;
show variable keep_transaction_alive;
NEW_CONNECTION;
SHOW VARIABLE KEEP_TRANSACTION_ALIVE;
NEW_CONNECTION;
show variable keep_transaction_alive;
NEW_CONNECTION;
   show variable keep_transaction_alive;
NEW_CONNECTION;
			show variable keep_transaction_alive;
NEW_CONNECTION;



show variable keep_transaction_alive;
NEW_CONNECTION;
show variable keep_transaction_alive  ;
NEW_CONNECTION;
show variable keep_transaction_alive		;
NEW_CONNECTION;
show variable keep_transaction_alive

;
NEW_CONNECTION;
show   variable   keep_transaction_alive;
NEW_CONNECTION;
show	variable	keep_transaction_alive;
NEW_CONNECTION;
show
variable
keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable keep_transaction_alive;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable keep_transaction_alive/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-keep_transaction_alive;
NEW_CONNECTION;
show variable auto_batch_dml;
NEW_CONNECTION;
SHOW VARIABLE AUTO_BATCH_DML;
NEW_CONNECTION;
show variable auto_batch_dml;
NEW_CONNECTION;
   show variable auto_batch_dml;
NEW_CONNECTION;
			show variable auto_batch_dml;
NEW_CONNECTION;



show variable auto_batch_dml;
NEW_CONNECTION;
show variable auto_batch_dml  ;
NEW_CONNECTION;
show variable auto_batch_dml		;
NEW_CONNECTION;
show variable auto_batch_dml

;
NEW_CONNECTION;
show   variable   auto_batch_dml;
NEW_CONNECTION;
show	variable	auto_batch_dml;
NEW_CONNECTION;
show
variable
auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable auto_batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-auto_batch_dml;
NEW_CONNECTION;
show variable auto_batch_dml_update_count;
NEW_CONNECTION;
SHOW VARIABLE AUTO_BATCH_DML_UPDATE_COUNT;
NEW_CONNECTION;
show variable auto_batch_dml_update_count;
NEW_CONNECTION;
   show variable auto_batch_dml_update_count;
NEW_CONNECTION;
			show variable auto_batch_dml_update_count;
NEW_CONNECTION;



show variable auto_batch_dml_update_count;
NEW_CONNECTION;
show variable auto_batch_dml_update_count  ;
NEW_CONNECTION;
show variable auto_batch_dml_update_count		;
NEW_CONNECTION;
show variable auto_batch_dml_update_count

;
NEW_CONNECTION;
show   variable   auto_batch_dml_update_count;
NEW_CONNECTION;
show	variable	auto_batch_dml_update_count;
NEW_CONNECTION;
show
variable
auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable auto_batch_dml_update_count;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-auto_batch_dml_update_count;
NEW_CONNECTION;
show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
SHOW VARIABLE AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION;
NEW_CONNECTION;
show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
   show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
			show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;



show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
show variable auto_batch_dml_update_count_verification  ;
NEW_CONNECTION;
show variable auto_batch_dml_update_count_verification		;
NEW_CONNECTION;
show variable auto_batch_dml_update_count_verification

;
NEW_CONNECTION;
show   variable   auto_batch_dml_update_count_verification;
NEW_CONNECTION;
show	variable	auto_batch_dml_update_count_verification;
NEW_CONNECTION;
show
variable
auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable auto_batch_dml_update_count_verification;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_batch_dml_update_count_verification/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-auto_batch_dml_update_count_verification;
NEW_CONNECTION;
partition select col1, col2 from my_table;
NEW_CONNECTION;
PARTITION SELECT COL1, COL2 FROM MY_TABLE;
NEW_CONNECTION;
partition select col1, col2 from my_table;
NEW_CONNECTION;
   partition select col1, col2 from my_table;
NEW_CONNECTION;
			partition select col1, col2 from my_table;
NEW_CONNECTION;



partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table  ;
NEW_CONNECTION;
partition select col1, col2 from my_table		;
NEW_CONNECTION;
partition select col1, col2 from my_table

;
NEW_CONNECTION;
partition   select   col1,   col2   from   my_table;
NEW_CONNECTION;
partition	select	col1,	col2	from	my_table;
NEW_CONNECTION;
partition
select
col1,
col2
from
my_table;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-partition select col1, col2 from my_table;
NEW_CONNECTION;
partition select col1, col2 from my_table/-;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
RUN PARTITIONED QUERY SELECT COL1, COL2 FROM MY_TABLE;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
   run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
			run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;



run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table  ;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table		;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table

;
NEW_CONNECTION;
run   partitioned   query   select   col1,   col2   from   my_table;
NEW_CONNECTION;
run	partitioned	query	select	col1,	col2	from	my_table;
NEW_CONNECTION;
run
partitioned
query
select
col1,
col2
from
my_table;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-run partitioned query select col1, col2 from my_table;
NEW_CONNECTION;
run partitioned query select col1, col2 from my_table/-;
NEW_CONNECTION;
begin;
NEW_CONNECTION;
BEGIN;
NEW_CONNECTION;
begin;
NEW_CONNECTION;
   begin;
NEW_CONNECTION;
			begin;
NEW_CONNECTION;



begin;
NEW_CONNECTION;
begin  ;
NEW_CONNECTION;
begin		;
NEW_CONNECTION;
begin

;
NEW_CONNECTION;
begin;
NEW_CONNECTION;
begin;
NEW_CONNECTION;
begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-begin;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin/-;
NEW_CONNECTION;
start;
NEW_CONNECTION;
START;
NEW_CONNECTION;
start;
NEW_CONNECTION;
   start;
NEW_CONNECTION;
			start;
NEW_CONNECTION;



start;
NEW_CONNECTION;
start  ;
NEW_CONNECTION;
start		;
NEW_CONNECTION;
start

;
NEW_CONNECTION;
start;
NEW_CONNECTION;
start;
NEW_CONNECTION;
start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-start;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start/-;
NEW_CONNECTION;
begin transaction;
NEW_CONNECTION;
BEGIN TRANSACTION;
NEW_CONNECTION;
begin transaction;
NEW_CONNECTION;
   begin transaction;
NEW_CONNECTION;
			begin transaction;
NEW_CONNECTION;



begin transaction;
NEW_CONNECTION;
begin transaction  ;
NEW_CONNECTION;
begin transaction		;
NEW_CONNECTION;
begin transaction

;
NEW_CONNECTION;
begin   transaction;
NEW_CONNECTION;
begin	transaction;
NEW_CONNECTION;
begin
transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin%transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin_transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin&transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin$transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin@transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin!transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin*transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin(transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin)transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin-transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin+transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin-#transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin/transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin\transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin?transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin-/transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin/#transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-begin transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin/-transaction;
NEW_CONNECTION;
start transaction;
NEW_CONNECTION;
START TRANSACTION;
NEW_CONNECTION;
start transaction;
NEW_CONNECTION;
   start transaction;
NEW_CONNECTION;
			start transaction;
NEW_CONNECTION;



start transaction;
NEW_CONNECTION;
start transaction  ;
NEW_CONNECTION;
start transaction		;
NEW_CONNECTION;
start transaction

;
NEW_CONNECTION;
start   transaction;
NEW_CONNECTION;
start	transaction;
NEW_CONNECTION;
start
transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start%transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start_transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start&transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start$transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start@transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start!transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start*transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start(transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start)transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start-transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start+transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start-#transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start/transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start\transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start?transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start-/transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start/#transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-start transaction;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start/-transaction;
NEW_CONNECTION;
begin isolation level repeatable read;
NEW_CONNECTION;
BEGIN ISOLATION LEVEL REPEATABLE READ;
NEW_CONNECTION;
begin isolation level repeatable read;
NEW_CONNECTION;
   begin isolation level repeatable read;
NEW_CONNECTION;
			begin isolation level repeatable read;
NEW_CONNECTION;



begin isolation level repeatable read;
NEW_CONNECTION;
begin isolation level repeatable read  ;
NEW_CONNECTION;
begin isolation level repeatable read		;
NEW_CONNECTION;
begin isolation level repeatable read

;
NEW_CONNECTION;
begin   isolation   level   repeatable   read;
NEW_CONNECTION;
begin	isolation	level	repeatable	read;
NEW_CONNECTION;
begin
isolation
level
repeatable
read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable%read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable&read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable$read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable@read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable!read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable*read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable(read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable)read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable-read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable+read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable-#read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable/read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable\read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable?read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable-/read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable/#read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-begin isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable read/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level repeatable/-read;
NEW_CONNECTION;
begin transaction isolation level repeatable read;
NEW_CONNECTION;
BEGIN TRANSACTION ISOLATION LEVEL REPEATABLE READ;
NEW_CONNECTION;
begin transaction isolation level repeatable read;
NEW_CONNECTION;
   begin transaction isolation level repeatable read;
NEW_CONNECTION;
			begin transaction isolation level repeatable read;
NEW_CONNECTION;



begin transaction isolation level repeatable read;
NEW_CONNECTION;
begin transaction isolation level repeatable read  ;
NEW_CONNECTION;
begin transaction isolation level repeatable read		;
NEW_CONNECTION;
begin transaction isolation level repeatable read

;
NEW_CONNECTION;
begin   transaction   isolation   level   repeatable   read;
NEW_CONNECTION;
begin	transaction	isolation	level	repeatable	read;
NEW_CONNECTION;
begin
transaction
isolation
level
repeatable
read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable%read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable&read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable$read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable@read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable!read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable*read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable(read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable)read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable-read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable+read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable-#read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable/read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable\read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable?read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable-/read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable/#read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-begin transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable read/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level repeatable/-read;
NEW_CONNECTION;
begin isolation level serializable;
NEW_CONNECTION;
BEGIN ISOLATION LEVEL SERIALIZABLE;
NEW_CONNECTION;
begin isolation level serializable;
NEW_CONNECTION;
   begin isolation level serializable;
NEW_CONNECTION;
			begin isolation level serializable;
NEW_CONNECTION;



begin isolation level serializable;
NEW_CONNECTION;
begin isolation level serializable  ;
NEW_CONNECTION;
begin isolation level serializable		;
NEW_CONNECTION;
begin isolation level serializable

;
NEW_CONNECTION;
begin   isolation   level   serializable;
NEW_CONNECTION;
begin	isolation	level	serializable;
NEW_CONNECTION;
begin
isolation
level
serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level%serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level_serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level&serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level$serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level@serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level!serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level*serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level(serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level)serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level-serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level+serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level-#serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level/serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level\serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level?serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level-/serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level/#serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-begin isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level serializable/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin isolation level/-serializable;
NEW_CONNECTION;
begin transaction isolation level serializable;
NEW_CONNECTION;
BEGIN TRANSACTION ISOLATION LEVEL SERIALIZABLE;
NEW_CONNECTION;
begin transaction isolation level serializable;
NEW_CONNECTION;
   begin transaction isolation level serializable;
NEW_CONNECTION;
			begin transaction isolation level serializable;
NEW_CONNECTION;



begin transaction isolation level serializable;
NEW_CONNECTION;
begin transaction isolation level serializable  ;
NEW_CONNECTION;
begin transaction isolation level serializable		;
NEW_CONNECTION;
begin transaction isolation level serializable

;
NEW_CONNECTION;
begin   transaction   isolation   level   serializable;
NEW_CONNECTION;
begin	transaction	isolation	level	serializable;
NEW_CONNECTION;
begin
transaction
isolation
level
serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level%serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level_serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level&serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level$serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level@serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level!serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level*serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level(serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level)serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level-serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level+serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level-#serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level/serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level\serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level?serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level-/serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level/#serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-begin transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level serializable/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
begin transaction isolation level/-serializable;
NEW_CONNECTION;
start isolation level repeatable read;
NEW_CONNECTION;
START ISOLATION LEVEL REPEATABLE READ;
NEW_CONNECTION;
start isolation level repeatable read;
NEW_CONNECTION;
   start isolation level repeatable read;
NEW_CONNECTION;
			start isolation level repeatable read;
NEW_CONNECTION;



start isolation level repeatable read;
NEW_CONNECTION;
start isolation level repeatable read  ;
NEW_CONNECTION;
start isolation level repeatable read		;
NEW_CONNECTION;
start isolation level repeatable read

;
NEW_CONNECTION;
start   isolation   level   repeatable   read;
NEW_CONNECTION;
start	isolation	level	repeatable	read;
NEW_CONNECTION;
start
isolation
level
repeatable
read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable%read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable&read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable$read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable@read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable!read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable*read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable(read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable)read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable-read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable+read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable-#read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable/read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable\read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable?read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable-/read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable/#read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-start isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable read/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level repeatable/-read;
NEW_CONNECTION;
start transaction isolation level repeatable read;
NEW_CONNECTION;
START TRANSACTION ISOLATION LEVEL REPEATABLE READ;
NEW_CONNECTION;
start transaction isolation level repeatable read;
NEW_CONNECTION;
   start transaction isolation level repeatable read;
NEW_CONNECTION;
			start transaction isolation level repeatable read;
NEW_CONNECTION;



start transaction isolation level repeatable read;
NEW_CONNECTION;
start transaction isolation level repeatable read  ;
NEW_CONNECTION;
start transaction isolation level repeatable read		;
NEW_CONNECTION;
start transaction isolation level repeatable read

;
NEW_CONNECTION;
start   transaction   isolation   level   repeatable   read;
NEW_CONNECTION;
start	transaction	isolation	level	repeatable	read;
NEW_CONNECTION;
start
transaction
isolation
level
repeatable
read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable%read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable_read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable&read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable$read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable@read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable!read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable*read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable(read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable)read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable-read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable+read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable-#read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable/read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable\read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable?read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable-/read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable/#read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-start transaction isolation level repeatable read;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable read/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level repeatable/-read;
NEW_CONNECTION;
start isolation level serializable;
NEW_CONNECTION;
START ISOLATION LEVEL SERIALIZABLE;
NEW_CONNECTION;
start isolation level serializable;
NEW_CONNECTION;
   start isolation level serializable;
NEW_CONNECTION;
			start isolation level serializable;
NEW_CONNECTION;



start isolation level serializable;
NEW_CONNECTION;
start isolation level serializable  ;
NEW_CONNECTION;
start isolation level serializable		;
NEW_CONNECTION;
start isolation level serializable

;
NEW_CONNECTION;
start   isolation   level   serializable;
NEW_CONNECTION;
start	isolation	level	serializable;
NEW_CONNECTION;
start
isolation
level
serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level%serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level_serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level&serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level$serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level@serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level!serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level*serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level(serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level)serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level-serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level+serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level-#serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level/serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level\serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level?serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level-/serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level/#serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-start isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level serializable/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start isolation level/-serializable;
NEW_CONNECTION;
start transaction isolation level serializable;
NEW_CONNECTION;
START TRANSACTION ISOLATION LEVEL SERIALIZABLE;
NEW_CONNECTION;
start transaction isolation level serializable;
NEW_CONNECTION;
   start transaction isolation level serializable;
NEW_CONNECTION;
			start transaction isolation level serializable;
NEW_CONNECTION;



start transaction isolation level serializable;
NEW_CONNECTION;
start transaction isolation level serializable  ;
NEW_CONNECTION;
start transaction isolation level serializable		;
NEW_CONNECTION;
start transaction isolation level serializable

;
NEW_CONNECTION;
start   transaction   isolation   level   serializable;
NEW_CONNECTION;
start	transaction	isolation	level	serializable;
NEW_CONNECTION;
start
transaction
isolation
level
serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level%serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level_serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level&serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level$serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level@serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level!serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level*serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level(serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level)serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level-serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level+serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level-#serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level/serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level\serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level?serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level-/serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level/#serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-start transaction isolation level serializable;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level serializable/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start transaction isolation level/-serializable;
NEW_CONNECTION;
begin transaction;
commit;
NEW_CONNECTION;
begin transaction;
COMMIT;
NEW_CONNECTION;
begin transaction;
commit;
NEW_CONNECTION;
begin transaction;
   commit;
NEW_CONNECTION;
begin transaction;
			commit;
NEW_CONNECTION;
begin transaction;



commit;
NEW_CONNECTION;
begin transaction;
commit  ;
NEW_CONNECTION;
begin transaction;
commit		;
NEW_CONNECTION;
begin transaction;
commit

;
NEW_CONNECTION;
begin transaction;
commit;
NEW_CONNECTION;
begin transaction;
commit;
NEW_CONNECTION;
begin transaction;
commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit bar;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
%commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit%;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit%;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
_commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit_;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit_;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
&commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit&;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit&;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
$commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit$;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit$;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
@commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit@;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit@;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
!commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit!;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit!;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
*commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit*;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit*;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
(commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit(;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit(;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
)commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit);
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit);
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
-commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit-;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit-;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
+commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit+;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit+;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit-#;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit-#;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
/commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit/;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit/;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
\commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit\;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit\;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
?commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit?;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit?;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit-/;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit-/;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit/#;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit/#;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-commit;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit/-;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit/-;
NEW_CONNECTION;
begin transaction;
commit transaction;
NEW_CONNECTION;
begin transaction;
COMMIT TRANSACTION;
NEW_CONNECTION;
begin transaction;
commit transaction;
NEW_CONNECTION;
begin transaction;
   commit transaction;
NEW_CONNECTION;
begin transaction;
			commit transaction;
NEW_CONNECTION;
begin transaction;



commit transaction;
NEW_CONNECTION;
begin transaction;
commit transaction  ;
NEW_CONNECTION;
begin transaction;
commit transaction		;
NEW_CONNECTION;
begin transaction;
commit transaction

;
NEW_CONNECTION;
begin transaction;
commit   transaction;
NEW_CONNECTION;
begin transaction;
commit	transaction;
NEW_CONNECTION;
begin transaction;
commit
transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction bar;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
%commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction%;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit%transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
_commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction_;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit_transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
&commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction&;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit&transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
$commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction$;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit$transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
@commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction@;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit@transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
!commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction!;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit!transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
*commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction*;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit*transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
(commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction(;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit(transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
)commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction);
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit)transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
-commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction-;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit-transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
+commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction+;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit+transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction-#;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit-#transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
/commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction/;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit/transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
\commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction\;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit\transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
?commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction?;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit?transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction-/;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit-/transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction/#;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit/#transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-commit transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit transaction/-;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
commit/-transaction;
NEW_CONNECTION;
begin transaction;
rollback;
NEW_CONNECTION;
begin transaction;
ROLLBACK;
NEW_CONNECTION;
begin transaction;
rollback;
NEW_CONNECTION;
begin transaction;
   rollback;
NEW_CONNECTION;
begin transaction;
			rollback;
NEW_CONNECTION;
begin transaction;



rollback;
NEW_CONNECTION;
begin transaction;
rollback  ;
NEW_CONNECTION;
begin transaction;
rollback		;
NEW_CONNECTION;
begin transaction;
rollback

;
NEW_CONNECTION;
begin transaction;
rollback;
NEW_CONNECTION;
begin transaction;
rollback;
NEW_CONNECTION;
begin transaction;
rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback bar;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
%rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback%;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback%;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
_rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback_;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback_;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
&rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback&;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback&;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
$rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback$;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback$;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
@rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback@;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback@;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
!rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback!;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback!;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
*rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback*;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback*;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
(rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback(;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback(;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
)rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback);
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback);
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
-rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback-;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback-;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
+rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback+;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback+;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback-#;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback-#;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
/rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback/;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback/;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
\rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback\;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback\;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
?rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback?;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback?;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback-/;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback-/;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback/#;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback/#;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-rollback;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback/-;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback/-;
NEW_CONNECTION;
begin transaction;
rollback transaction;
NEW_CONNECTION;
begin transaction;
ROLLBACK TRANSACTION;
NEW_CONNECTION;
begin transaction;
rollback transaction;
NEW_CONNECTION;
begin transaction;
   rollback transaction;
NEW_CONNECTION;
begin transaction;
			rollback transaction;
NEW_CONNECTION;
begin transaction;



rollback transaction;
NEW_CONNECTION;
begin transaction;
rollback transaction  ;
NEW_CONNECTION;
begin transaction;
rollback transaction		;
NEW_CONNECTION;
begin transaction;
rollback transaction

;
NEW_CONNECTION;
begin transaction;
rollback   transaction;
NEW_CONNECTION;
begin transaction;
rollback	transaction;
NEW_CONNECTION;
begin transaction;
rollback
transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction bar;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
%rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction%;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback%transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
_rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction_;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback_transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
&rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction&;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback&transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
$rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction$;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback$transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
@rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction@;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback@transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
!rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction!;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback!transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
*rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction*;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback*transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
(rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction(;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback(transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
)rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction);
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback)transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
-rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction-;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback-transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
+rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction+;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback+transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction-#;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback-#transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
/rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction/;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback/transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
\rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction\;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback\transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
?rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction?;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback?transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction-/;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback-/transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction/#;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback/#transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-rollback transaction;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback transaction/-;
NEW_CONNECTION;
begin transaction;
@EXPECT EXCEPTION INVALID_ARGUMENT
rollback/-transaction;
NEW_CONNECTION;
start batch ddl;
NEW_CONNECTION;
START BATCH DDL;
NEW_CONNECTION;
start batch ddl;
NEW_CONNECTION;
   start batch ddl;
NEW_CONNECTION;
			start batch ddl;
NEW_CONNECTION;



start batch ddl;
NEW_CONNECTION;
start batch ddl  ;
NEW_CONNECTION;
start batch ddl		;
NEW_CONNECTION;
start batch ddl

;
NEW_CONNECTION;
start   batch   ddl;
NEW_CONNECTION;
start	batch	ddl;
NEW_CONNECTION;
start
batch
ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch%ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch_ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch&ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch$ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch@ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch!ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch*ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch(ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch)ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch-ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch+ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch-#ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch/ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch\ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch?ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch-/ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch/#ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-start batch ddl;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch ddl/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch/-ddl;
NEW_CONNECTION;
start batch dml;
NEW_CONNECTION;
START BATCH DML;
NEW_CONNECTION;
start batch dml;
NEW_CONNECTION;
   start batch dml;
NEW_CONNECTION;
			start batch dml;
NEW_CONNECTION;



start batch dml;
NEW_CONNECTION;
start batch dml  ;
NEW_CONNECTION;
start batch dml		;
NEW_CONNECTION;
start batch dml

;
NEW_CONNECTION;
start   batch   dml;
NEW_CONNECTION;
start	batch	dml;
NEW_CONNECTION;
start
batch
dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch%dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch_dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch&dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch$dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch@dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch!dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch*dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch(dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch)dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch-dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch+dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch-#dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch/dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch\dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch?dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch-/dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch/#dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-start batch dml;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch dml/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
start batch/-dml;
NEW_CONNECTION;
start batch ddl;
run batch;
NEW_CONNECTION;
start batch ddl;
RUN BATCH;
NEW_CONNECTION;
start batch ddl;
run batch;
NEW_CONNECTION;
start batch ddl;
   run batch;
NEW_CONNECTION;
start batch ddl;
			run batch;
NEW_CONNECTION;
start batch ddl;



run batch;
NEW_CONNECTION;
start batch ddl;
run batch  ;
NEW_CONNECTION;
start batch ddl;
run batch		;
NEW_CONNECTION;
start batch ddl;
run batch

;
NEW_CONNECTION;
start batch ddl;
run   batch;
NEW_CONNECTION;
start batch ddl;
run	batch;
NEW_CONNECTION;
start batch ddl;
run
batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch bar;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
%run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch%;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run%batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
_run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch_;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run_batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
&run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch&;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run&batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
$run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch$;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run$batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
@run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch@;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run@batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
!run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch!;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run!batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
*run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch*;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run*batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
(run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch(;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run(batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
)run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch);
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run)batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
-run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch-;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run-batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
+run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch+;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run+batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch-#;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run-#batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
/run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch/;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run/batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
\run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch\;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run\batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
?run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch?;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run?batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch-/;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run-/batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch/#;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run/#batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-run batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run batch/-;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
run/-batch;
NEW_CONNECTION;
start batch ddl;
abort batch;
NEW_CONNECTION;
start batch ddl;
ABORT BATCH;
NEW_CONNECTION;
start batch ddl;
abort batch;
NEW_CONNECTION;
start batch ddl;
   abort batch;
NEW_CONNECTION;
start batch ddl;
			abort batch;
NEW_CONNECTION;
start batch ddl;



abort batch;
NEW_CONNECTION;
start batch ddl;
abort batch  ;
NEW_CONNECTION;
start batch ddl;
abort batch		;
NEW_CONNECTION;
start batch ddl;
abort batch

;
NEW_CONNECTION;
start batch ddl;
abort   batch;
NEW_CONNECTION;
start batch ddl;
abort	batch;
NEW_CONNECTION;
start batch ddl;
abort
batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch bar;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
%abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch%;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort%batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
_abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch_;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort_batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
&abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch&;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort&batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
$abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch$;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort$batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
@abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch@;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort@batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
!abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch!;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort!batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
*abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch*;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort*batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
(abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch(;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort(batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
)abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch);
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort)batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
-abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch-;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort-batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
+abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch+;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort+batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch-#;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort-#batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
/abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch/;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort/batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
\abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch\;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort\batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
?abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch?;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort?batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch-/;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort-/batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch/#;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort/#batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-abort batch;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort batch/-;
NEW_CONNECTION;
start batch ddl;
@EXPECT EXCEPTION INVALID_ARGUMENT
abort/-batch;
NEW_CONNECTION;
reset all;
NEW_CONNECTION;
RESET ALL;
NEW_CONNECTION;
reset all;
NEW_CONNECTION;
   reset all;
NEW_CONNECTION;
			reset all;
NEW_CONNECTION;



reset all;
NEW_CONNECTION;
reset all  ;
NEW_CONNECTION;
reset all		;
NEW_CONNECTION;
reset all

;
NEW_CONNECTION;
reset   all;
NEW_CONNECTION;
reset	all;
NEW_CONNECTION;
reset
all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset%all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset_all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset&all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset$all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset@all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset!all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset*all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset(all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset)all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset-all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset+all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset-#all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset/all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset\all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset?all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset-/all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset/#all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-reset all;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset all/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
reset/-all;
NEW_CONNECTION;
set autocommit = true;
NEW_CONNECTION;
SET AUTOCOMMIT = TRUE;
NEW_CONNECTION;
set autocommit = true;
NEW_CONNECTION;
   set autocommit = true;
NEW_CONNECTION;
			set autocommit = true;
NEW_CONNECTION;



set autocommit = true;
NEW_CONNECTION;
set autocommit = true  ;
NEW_CONNECTION;
set autocommit = true		;
NEW_CONNECTION;
set autocommit = true

;
NEW_CONNECTION;
set   autocommit   =   true;
NEW_CONNECTION;
set	autocommit	=	true;
NEW_CONNECTION;
set
autocommit
=
true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =%true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =_true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =&true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =$true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =@true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =!true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =*true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =(true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =)true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =-true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =+true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =-#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =\true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =?true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =-/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =/#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set autocommit = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = true/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =/-true;
NEW_CONNECTION;
set autocommit = false;
NEW_CONNECTION;
SET AUTOCOMMIT = FALSE;
NEW_CONNECTION;
set autocommit = false;
NEW_CONNECTION;
   set autocommit = false;
NEW_CONNECTION;
			set autocommit = false;
NEW_CONNECTION;



set autocommit = false;
NEW_CONNECTION;
set autocommit = false  ;
NEW_CONNECTION;
set autocommit = false		;
NEW_CONNECTION;
set autocommit = false

;
NEW_CONNECTION;
set   autocommit   =   false;
NEW_CONNECTION;
set	autocommit	=	false;
NEW_CONNECTION;
set
autocommit
=
false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =%false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =_false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =&false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =$false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =@false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =!false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =*false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =(false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =)false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =-false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =+false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =-#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =\false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =?false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =-/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =/#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set autocommit = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit = false/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit =/-false;
NEW_CONNECTION;
set readonly = true;
NEW_CONNECTION;
SET READONLY = TRUE;
NEW_CONNECTION;
set readonly = true;
NEW_CONNECTION;
   set readonly = true;
NEW_CONNECTION;
			set readonly = true;
NEW_CONNECTION;



set readonly = true;
NEW_CONNECTION;
set readonly = true  ;
NEW_CONNECTION;
set readonly = true		;
NEW_CONNECTION;
set readonly = true

;
NEW_CONNECTION;
set   readonly   =   true;
NEW_CONNECTION;
set	readonly	=	true;
NEW_CONNECTION;
set
readonly
=
true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =%true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =_true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =&true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =$true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =@true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =!true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =*true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =(true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =)true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =-true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =+true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =-#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =\true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =?true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =-/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =/#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set readonly = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = true/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =/-true;
NEW_CONNECTION;
set readonly = false;
NEW_CONNECTION;
SET READONLY = FALSE;
NEW_CONNECTION;
set readonly = false;
NEW_CONNECTION;
   set readonly = false;
NEW_CONNECTION;
			set readonly = false;
NEW_CONNECTION;



set readonly = false;
NEW_CONNECTION;
set readonly = false  ;
NEW_CONNECTION;
set readonly = false		;
NEW_CONNECTION;
set readonly = false

;
NEW_CONNECTION;
set   readonly   =   false;
NEW_CONNECTION;
set	readonly	=	false;
NEW_CONNECTION;
set
readonly
=
false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =%false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =_false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =&false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =$false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =@false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =!false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =*false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =(false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =)false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =-false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =+false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =-#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =\false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =?false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =-/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =/#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set readonly = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly = false/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set readonly =/-false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
SET RETRY_ABORTS_INTERNALLY = TRUE;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
   set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
			set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;



set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set retry_aborts_internally = true  ;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set retry_aborts_internally = true		;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set retry_aborts_internally = true

;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set   retry_aborts_internally   =   true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set	retry_aborts_internally	=	true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set
retry_aborts_internally
=
true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true bar;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true%;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =%true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true_;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =_true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true&;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =&true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true$;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =$true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true@;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =@true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true!;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =!true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true*;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =*true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true(;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =(true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true);
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =)true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =-true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true+;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =+true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true-#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =-#true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =/true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true\;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =\true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true?;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =?true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true-/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =-/true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true/#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =/#true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = true/-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =/-true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
SET RETRY_ABORTS_INTERNALLY = FALSE;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
   set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
			set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;



set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set retry_aborts_internally = false  ;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set retry_aborts_internally = false		;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set retry_aborts_internally = false

;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set   retry_aborts_internally   =   false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set	retry_aborts_internally	=	false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set
retry_aborts_internally
=
false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false bar;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false%;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =%false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false_;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =_false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false&;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =&false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false$;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =$false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false@;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =@false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false!;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =!false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false*;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =*false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false(;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =(false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false);
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =)false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =-false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false+;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =+false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false-#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =-#false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =/false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false\;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =\false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false?;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =?false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false-/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =-/false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false/#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =/#false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally = false/-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set retry_aborts_internally =/-false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
SET LOCAL RETRY_ABORTS_INTERNALLY = TRUE;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
   set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
			set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;



set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local retry_aborts_internally = true  ;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local retry_aborts_internally = true		;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local retry_aborts_internally = true

;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set   local   retry_aborts_internally   =   true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set	local	retry_aborts_internally	=	true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set
local
retry_aborts_internally
=
true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true bar;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true%;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =%true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true_;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =_true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true&;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =&true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true$;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =$true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true@;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =@true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true!;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =!true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true*;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =*true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true(;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =(true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true);
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =)true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =-true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true+;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =+true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true-#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =-#true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =/true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true\;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =\true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true?;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =?true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true-/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =-/true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true/#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =/#true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set local retry_aborts_internally = true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = true/-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =/-true;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
SET LOCAL RETRY_ABORTS_INTERNALLY = FALSE;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
   set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
			set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;



set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local retry_aborts_internally = false  ;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local retry_aborts_internally = false		;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local retry_aborts_internally = false

;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set   local   retry_aborts_internally   =   false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set	local	retry_aborts_internally	=	false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set
local
retry_aborts_internally
=
false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false bar;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false%;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =%false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false_;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =_false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false&;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =&false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false$;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =$false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false@;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =@false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false!;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =!false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false*;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =*false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false(;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =(false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false);
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =)false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =-false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false+;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =+false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false-#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =-#false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =/false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false\;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =\false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false?;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =?false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false-/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =-/false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false/#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =/#false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set local retry_aborts_internally = false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally = false/-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local retry_aborts_internally =/-false;
NEW_CONNECTION;
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
SET AUTOCOMMIT_DML_MODE='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
set autocommit_dml_mode='partitioned_non_atomic';
NEW_CONNECTION;
   set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
			set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;



set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'  ;
NEW_CONNECTION;
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'		;
NEW_CONNECTION;
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'

;
NEW_CONNECTION;
set   autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
set	autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
set
autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='PARTITIONED_NON_ATOMIC'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-autocommit_dml_mode='PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
SET AUTOCOMMIT_DML_MODE='TRANSACTIONAL';
NEW_CONNECTION;
set autocommit_dml_mode='transactional';
NEW_CONNECTION;
   set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
			set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;



set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
set autocommit_dml_mode='TRANSACTIONAL'  ;
NEW_CONNECTION;
set autocommit_dml_mode='TRANSACTIONAL'		;
NEW_CONNECTION;
set autocommit_dml_mode='TRANSACTIONAL'

;
NEW_CONNECTION;
set   autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
set	autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
set
autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-autocommit_dml_mode='TRANSACTIONAL';
NEW_CONNECTION;
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
SET AUTOCOMMIT_DML_MODE='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
set autocommit_dml_mode='transactional_with_fallback_to_partitioned_non_atomic';
NEW_CONNECTION;
   set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
			set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;



set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'  ;
NEW_CONNECTION;
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'		;
NEW_CONNECTION;
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'

;
NEW_CONNECTION;
set   autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
set	autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
set
autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-autocommit_dml_mode='TRANSACTIONAL_WITH_FALLBACK_TO_PARTITIONED_NON_ATOMIC';
NEW_CONNECTION;
set statement_timeout=null;
NEW_CONNECTION;
SET STATEMENT_TIMEOUT=NULL;
NEW_CONNECTION;
set statement_timeout=null;
NEW_CONNECTION;
   set statement_timeout=null;
NEW_CONNECTION;
			set statement_timeout=null;
NEW_CONNECTION;



set statement_timeout=null;
NEW_CONNECTION;
set statement_timeout=null  ;
NEW_CONNECTION;
set statement_timeout=null		;
NEW_CONNECTION;
set statement_timeout=null

;
NEW_CONNECTION;
set   statement_timeout=null;
NEW_CONNECTION;
set	statement_timeout=null;
NEW_CONNECTION;
set
statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set statement_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=null/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-statement_timeout=null;
NEW_CONNECTION;
set statement_timeout = null ;
NEW_CONNECTION;
SET STATEMENT_TIMEOUT = NULL ;
NEW_CONNECTION;
set statement_timeout = null ;
NEW_CONNECTION;
   set statement_timeout = null ;
NEW_CONNECTION;
			set statement_timeout = null ;
NEW_CONNECTION;



set statement_timeout = null ;
NEW_CONNECTION;
set statement_timeout = null   ;
NEW_CONNECTION;
set statement_timeout = null 		;
NEW_CONNECTION;
set statement_timeout = null 

;
NEW_CONNECTION;
set   statement_timeout   =   null   ;
NEW_CONNECTION;
set	statement_timeout	=	null	;
NEW_CONNECTION;
set
statement_timeout
=
null
;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null  bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null %;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null _;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null &;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null $;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null @;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null !;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null *;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null (;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null );
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null -;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null +;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null -#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null /;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null \;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null ?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null -/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null /#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set statement_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null /-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = null/-;
NEW_CONNECTION;
set statement_timeout='1s';
NEW_CONNECTION;
SET STATEMENT_TIMEOUT='1S';
NEW_CONNECTION;
set statement_timeout='1s';
NEW_CONNECTION;
   set statement_timeout='1s';
NEW_CONNECTION;
			set statement_timeout='1s';
NEW_CONNECTION;



set statement_timeout='1s';
NEW_CONNECTION;
set statement_timeout='1s'  ;
NEW_CONNECTION;
set statement_timeout='1s'		;
NEW_CONNECTION;
set statement_timeout='1s'

;
NEW_CONNECTION;
set   statement_timeout='1s';
NEW_CONNECTION;
set	statement_timeout='1s';
NEW_CONNECTION;
set
statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set statement_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='1s'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-statement_timeout='1s';
NEW_CONNECTION;
set statement_timeout = '1s' ;
NEW_CONNECTION;
SET STATEMENT_TIMEOUT = '1S' ;
NEW_CONNECTION;
set statement_timeout = '1s' ;
NEW_CONNECTION;
   set statement_timeout = '1s' ;
NEW_CONNECTION;
			set statement_timeout = '1s' ;
NEW_CONNECTION;



set statement_timeout = '1s' ;
NEW_CONNECTION;
set statement_timeout = '1s'   ;
NEW_CONNECTION;
set statement_timeout = '1s' 		;
NEW_CONNECTION;
set statement_timeout = '1s' 

;
NEW_CONNECTION;
set   statement_timeout   =   '1s'   ;
NEW_CONNECTION;
set	statement_timeout	=	'1s'	;
NEW_CONNECTION;
set
statement_timeout
=
'1s'
;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'  bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' %;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' _;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' &;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' $;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' @;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' !;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' *;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' (;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' );
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' -;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' +;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' -#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' /;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' \;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' ?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' -/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' /#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set statement_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s' /-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = '1s'/-;
NEW_CONNECTION;
set statement_timeout=100;
NEW_CONNECTION;
SET STATEMENT_TIMEOUT=100;
NEW_CONNECTION;
set statement_timeout=100;
NEW_CONNECTION;
   set statement_timeout=100;
NEW_CONNECTION;
			set statement_timeout=100;
NEW_CONNECTION;



set statement_timeout=100;
NEW_CONNECTION;
set statement_timeout=100  ;
NEW_CONNECTION;
set statement_timeout=100		;
NEW_CONNECTION;
set statement_timeout=100

;
NEW_CONNECTION;
set   statement_timeout=100;
NEW_CONNECTION;
set	statement_timeout=100;
NEW_CONNECTION;
set
statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100 bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set statement_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout=100/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-statement_timeout=100;
NEW_CONNECTION;
set statement_timeout = 100 ;
NEW_CONNECTION;
SET STATEMENT_TIMEOUT = 100 ;
NEW_CONNECTION;
set statement_timeout = 100 ;
NEW_CONNECTION;
   set statement_timeout = 100 ;
NEW_CONNECTION;
			set statement_timeout = 100 ;
NEW_CONNECTION;



set statement_timeout = 100 ;
NEW_CONNECTION;
set statement_timeout = 100   ;
NEW_CONNECTION;
set statement_timeout = 100 		;
NEW_CONNECTION;
set statement_timeout = 100 

;
NEW_CONNECTION;
set   statement_timeout   =   100   ;
NEW_CONNECTION;
set	statement_timeout	=	100	;
NEW_CONNECTION;
set
statement_timeout
=
100
;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100  bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 %;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 _;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 &;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 $;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 @;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 !;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 *;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 (;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 );
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 -;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 +;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 -#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 /;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 \;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 ?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 -/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 /#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set statement_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100 /-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout = 100/-;
NEW_CONNECTION;
set statement_timeout='100ms';
NEW_CONNECTION;
SET STATEMENT_TIMEOUT='100MS';
NEW_CONNECTION;
set statement_timeout='100ms';
NEW_CONNECTION;
   set statement_timeout='100ms';
NEW_CONNECTION;
			set statement_timeout='100ms';
NEW_CONNECTION;



set statement_timeout='100ms';
NEW_CONNECTION;
set statement_timeout='100ms'  ;
NEW_CONNECTION;
set statement_timeout='100ms'		;
NEW_CONNECTION;
set statement_timeout='100ms'

;
NEW_CONNECTION;
set   statement_timeout='100ms';
NEW_CONNECTION;
set	statement_timeout='100ms';
NEW_CONNECTION;
set
statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set statement_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='100ms'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-statement_timeout='100ms';
NEW_CONNECTION;
set statement_timeout='10000us';
NEW_CONNECTION;
SET STATEMENT_TIMEOUT='10000US';
NEW_CONNECTION;
set statement_timeout='10000us';
NEW_CONNECTION;
   set statement_timeout='10000us';
NEW_CONNECTION;
			set statement_timeout='10000us';
NEW_CONNECTION;



set statement_timeout='10000us';
NEW_CONNECTION;
set statement_timeout='10000us'  ;
NEW_CONNECTION;
set statement_timeout='10000us'		;
NEW_CONNECTION;
set statement_timeout='10000us'

;
NEW_CONNECTION;
set   statement_timeout='10000us';
NEW_CONNECTION;
set	statement_timeout='10000us';
NEW_CONNECTION;
set
statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set statement_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='10000us'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-statement_timeout='10000us';
NEW_CONNECTION;
set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
SET STATEMENT_TIMEOUT='9223372036854775807NS';
NEW_CONNECTION;
set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
   set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
			set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;



set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
set statement_timeout='9223372036854775807ns'  ;
NEW_CONNECTION;
set statement_timeout='9223372036854775807ns'		;
NEW_CONNECTION;
set statement_timeout='9223372036854775807ns'

;
NEW_CONNECTION;
set   statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
set	statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
set
statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_timeout='9223372036854775807ns'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-statement_timeout='9223372036854775807ns';
NEW_CONNECTION;
set transaction_timeout=null;
NEW_CONNECTION;
SET TRANSACTION_TIMEOUT=NULL;
NEW_CONNECTION;
set transaction_timeout=null;
NEW_CONNECTION;
   set transaction_timeout=null;
NEW_CONNECTION;
			set transaction_timeout=null;
NEW_CONNECTION;



set transaction_timeout=null;
NEW_CONNECTION;
set transaction_timeout=null  ;
NEW_CONNECTION;
set transaction_timeout=null		;
NEW_CONNECTION;
set transaction_timeout=null

;
NEW_CONNECTION;
set   transaction_timeout=null;
NEW_CONNECTION;
set	transaction_timeout=null;
NEW_CONNECTION;
set
transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set transaction_timeout=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=null/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-transaction_timeout=null;
NEW_CONNECTION;
set transaction_timeout = null ;
NEW_CONNECTION;
SET TRANSACTION_TIMEOUT = NULL ;
NEW_CONNECTION;
set transaction_timeout = null ;
NEW_CONNECTION;
   set transaction_timeout = null ;
NEW_CONNECTION;
			set transaction_timeout = null ;
NEW_CONNECTION;



set transaction_timeout = null ;
NEW_CONNECTION;
set transaction_timeout = null   ;
NEW_CONNECTION;
set transaction_timeout = null 		;
NEW_CONNECTION;
set transaction_timeout = null 

;
NEW_CONNECTION;
set   transaction_timeout   =   null   ;
NEW_CONNECTION;
set	transaction_timeout	=	null	;
NEW_CONNECTION;
set
transaction_timeout
=
null
;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null  bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null %;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null _;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null &;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null $;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null @;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null !;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null *;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null (;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null );
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null -;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null +;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null -#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null /;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null \;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null ?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null -/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null /#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set transaction_timeout = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null /-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = null/-;
NEW_CONNECTION;
set transaction_timeout='1s';
NEW_CONNECTION;
SET TRANSACTION_TIMEOUT='1S';
NEW_CONNECTION;
set transaction_timeout='1s';
NEW_CONNECTION;
   set transaction_timeout='1s';
NEW_CONNECTION;
			set transaction_timeout='1s';
NEW_CONNECTION;



set transaction_timeout='1s';
NEW_CONNECTION;
set transaction_timeout='1s'  ;
NEW_CONNECTION;
set transaction_timeout='1s'		;
NEW_CONNECTION;
set transaction_timeout='1s'

;
NEW_CONNECTION;
set   transaction_timeout='1s';
NEW_CONNECTION;
set	transaction_timeout='1s';
NEW_CONNECTION;
set
transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set transaction_timeout='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='1s'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-transaction_timeout='1s';
NEW_CONNECTION;
set transaction_timeout = '1s' ;
NEW_CONNECTION;
SET TRANSACTION_TIMEOUT = '1S' ;
NEW_CONNECTION;
set transaction_timeout = '1s' ;
NEW_CONNECTION;
   set transaction_timeout = '1s' ;
NEW_CONNECTION;
			set transaction_timeout = '1s' ;
NEW_CONNECTION;



set transaction_timeout = '1s' ;
NEW_CONNECTION;
set transaction_timeout = '1s'   ;
NEW_CONNECTION;
set transaction_timeout = '1s' 		;
NEW_CONNECTION;
set transaction_timeout = '1s' 

;
NEW_CONNECTION;
set   transaction_timeout   =   '1s'   ;
NEW_CONNECTION;
set	transaction_timeout	=	'1s'	;
NEW_CONNECTION;
set
transaction_timeout
=
'1s'
;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'  bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' %;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' _;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' &;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' $;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' @;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' !;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' *;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' (;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' );
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' -;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' +;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' -#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' /;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' \;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' ?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' -/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' /#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set transaction_timeout = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s' /-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = '1s'/-;
NEW_CONNECTION;
set transaction_timeout=100;
NEW_CONNECTION;
SET TRANSACTION_TIMEOUT=100;
NEW_CONNECTION;
set transaction_timeout=100;
NEW_CONNECTION;
   set transaction_timeout=100;
NEW_CONNECTION;
			set transaction_timeout=100;
NEW_CONNECTION;



set transaction_timeout=100;
NEW_CONNECTION;
set transaction_timeout=100  ;
NEW_CONNECTION;
set transaction_timeout=100		;
NEW_CONNECTION;
set transaction_timeout=100

;
NEW_CONNECTION;
set   transaction_timeout=100;
NEW_CONNECTION;
set	transaction_timeout=100;
NEW_CONNECTION;
set
transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100 bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set transaction_timeout=100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout=100/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-transaction_timeout=100;
NEW_CONNECTION;
set transaction_timeout = 100 ;
NEW_CONNECTION;
SET TRANSACTION_TIMEOUT = 100 ;
NEW_CONNECTION;
set transaction_timeout = 100 ;
NEW_CONNECTION;
   set transaction_timeout = 100 ;
NEW_CONNECTION;
			set transaction_timeout = 100 ;
NEW_CONNECTION;



set transaction_timeout = 100 ;
NEW_CONNECTION;
set transaction_timeout = 100   ;
NEW_CONNECTION;
set transaction_timeout = 100 		;
NEW_CONNECTION;
set transaction_timeout = 100 

;
NEW_CONNECTION;
set   transaction_timeout   =   100   ;
NEW_CONNECTION;
set	transaction_timeout	=	100	;
NEW_CONNECTION;
set
transaction_timeout
=
100
;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100  bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 %;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 _;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 &;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 $;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 @;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 !;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 *;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 (;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 );
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 -;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 +;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 -#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 /;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 \;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 ?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 -/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 /#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set transaction_timeout = 100 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100 /-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout = 100/-;
NEW_CONNECTION;
set transaction_timeout='100ms';
NEW_CONNECTION;
SET TRANSACTION_TIMEOUT='100MS';
NEW_CONNECTION;
set transaction_timeout='100ms';
NEW_CONNECTION;
   set transaction_timeout='100ms';
NEW_CONNECTION;
			set transaction_timeout='100ms';
NEW_CONNECTION;



set transaction_timeout='100ms';
NEW_CONNECTION;
set transaction_timeout='100ms'  ;
NEW_CONNECTION;
set transaction_timeout='100ms'		;
NEW_CONNECTION;
set transaction_timeout='100ms'

;
NEW_CONNECTION;
set   transaction_timeout='100ms';
NEW_CONNECTION;
set	transaction_timeout='100ms';
NEW_CONNECTION;
set
transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set transaction_timeout='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='100ms'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-transaction_timeout='100ms';
NEW_CONNECTION;
set transaction_timeout='10000us';
NEW_CONNECTION;
SET TRANSACTION_TIMEOUT='10000US';
NEW_CONNECTION;
set transaction_timeout='10000us';
NEW_CONNECTION;
   set transaction_timeout='10000us';
NEW_CONNECTION;
			set transaction_timeout='10000us';
NEW_CONNECTION;



set transaction_timeout='10000us';
NEW_CONNECTION;
set transaction_timeout='10000us'  ;
NEW_CONNECTION;
set transaction_timeout='10000us'		;
NEW_CONNECTION;
set transaction_timeout='10000us'

;
NEW_CONNECTION;
set   transaction_timeout='10000us';
NEW_CONNECTION;
set	transaction_timeout='10000us';
NEW_CONNECTION;
set
transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set transaction_timeout='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='10000us'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-transaction_timeout='10000us';
NEW_CONNECTION;
set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
SET TRANSACTION_TIMEOUT='9223372036854775807NS';
NEW_CONNECTION;
set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
   set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
			set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;



set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
set transaction_timeout='9223372036854775807ns'  ;
NEW_CONNECTION;
set transaction_timeout='9223372036854775807ns'		;
NEW_CONNECTION;
set transaction_timeout='9223372036854775807ns'

;
NEW_CONNECTION;
set   transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
set	transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
set
transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_timeout='9223372036854775807ns'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-transaction_timeout='9223372036854775807ns';
NEW_CONNECTION;
set autocommit = false;
set transaction read only;
NEW_CONNECTION;
set autocommit = false;
SET TRANSACTION READ ONLY;
NEW_CONNECTION;
set autocommit = false;
set transaction read only;
NEW_CONNECTION;
set autocommit = false;
   set transaction read only;
NEW_CONNECTION;
set autocommit = false;
			set transaction read only;
NEW_CONNECTION;
set autocommit = false;



set transaction read only;
NEW_CONNECTION;
set autocommit = false;
set transaction read only  ;
NEW_CONNECTION;
set autocommit = false;
set transaction read only		;
NEW_CONNECTION;
set autocommit = false;
set transaction read only

;
NEW_CONNECTION;
set autocommit = false;
set   transaction   read   only;
NEW_CONNECTION;
set autocommit = false;
set	transaction	read	only;
NEW_CONNECTION;
set autocommit = false;
set
transaction
read
only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only bar;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only%;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read%only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only_;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read_only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only&;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read&only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only$;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read$only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only@;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read@only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only!;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read!only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only*;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read*only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only(;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read(only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only);
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read)only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only-;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read-only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only+;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read+only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only-#;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read-#only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only/;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read/only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only\;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read\only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only?;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read?only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only-/;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read-/only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only/#;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read/#only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set transaction read only;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read only/-;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read/-only;
NEW_CONNECTION;
set autocommit = false;
set transaction read write;
NEW_CONNECTION;
set autocommit = false;
SET TRANSACTION READ WRITE;
NEW_CONNECTION;
set autocommit = false;
set transaction read write;
NEW_CONNECTION;
set autocommit = false;
   set transaction read write;
NEW_CONNECTION;
set autocommit = false;
			set transaction read write;
NEW_CONNECTION;
set autocommit = false;



set transaction read write;
NEW_CONNECTION;
set autocommit = false;
set transaction read write  ;
NEW_CONNECTION;
set autocommit = false;
set transaction read write		;
NEW_CONNECTION;
set autocommit = false;
set transaction read write

;
NEW_CONNECTION;
set autocommit = false;
set   transaction   read   write;
NEW_CONNECTION;
set autocommit = false;
set	transaction	read	write;
NEW_CONNECTION;
set autocommit = false;
set
transaction
read
write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write bar;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write%;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read%write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write_;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read_write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write&;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read&write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write$;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read$write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write@;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read@write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write!;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read!write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write*;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read*write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write(;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read(write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write);
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read)write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write-;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read-write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write+;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read+write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write-#;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read-#write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write/;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read/write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write\;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read\write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write?;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read?write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write-/;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read-/write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write/#;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read/#write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set transaction read write;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read write/-;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction read/-write;
NEW_CONNECTION;
set read_only_staleness='STRONG';
NEW_CONNECTION;
SET READ_ONLY_STALENESS='STRONG';
NEW_CONNECTION;
set read_only_staleness='strong';
NEW_CONNECTION;
   set read_only_staleness='STRONG';
NEW_CONNECTION;
			set read_only_staleness='STRONG';
NEW_CONNECTION;



set read_only_staleness='STRONG';
NEW_CONNECTION;
set read_only_staleness='STRONG'  ;
NEW_CONNECTION;
set read_only_staleness='STRONG'		;
NEW_CONNECTION;
set read_only_staleness='STRONG'

;
NEW_CONNECTION;
set   read_only_staleness='STRONG';
NEW_CONNECTION;
set	read_only_staleness='STRONG';
NEW_CONNECTION;
set
read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_only_staleness='STRONG';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='STRONG'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-read_only_staleness='STRONG';
NEW_CONNECTION;
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
SET READ_ONLY_STALENESS='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
set read_only_staleness='min_read_timestamp 2018-01-02t03:04:05.123-08:00';
NEW_CONNECTION;
   set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
			set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;



set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'  ;
NEW_CONNECTION;
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'		;
NEW_CONNECTION;
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'

;
NEW_CONNECTION;
set   read_only_staleness='MIN_READ_TIMESTAMP   2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
set	read_only_staleness='MIN_READ_TIMESTAMP	2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
set
read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP%2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP_2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP&2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP$2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP@2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP!2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP*2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP(2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP)2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP-2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP+2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP-#2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP/2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP\2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP?2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP-/2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP/#2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123-08:00'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP/-2018-01-02T03:04:05.123-08:00';
NEW_CONNECTION;
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
SET READ_ONLY_STALENESS='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
set read_only_staleness='min_read_timestamp 2018-01-02t03:04:05.123z';
NEW_CONNECTION;
   set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
			set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;



set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'  ;
NEW_CONNECTION;
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'		;
NEW_CONNECTION;
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'

;
NEW_CONNECTION;
set   read_only_staleness='MIN_READ_TIMESTAMP   2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
set	read_only_staleness='MIN_READ_TIMESTAMP	2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
set
read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP%2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP_2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP&2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP$2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP@2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP!2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP*2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP(2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP)2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP-2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP+2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP-#2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP/2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP\2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP?2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP-/2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP/#2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123Z'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP/-2018-01-02T03:04:05.123Z';
NEW_CONNECTION;
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
SET READ_ONLY_STALENESS='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
set read_only_staleness='min_read_timestamp 2018-01-02t03:04:05.123+07:45';
NEW_CONNECTION;
   set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
			set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;



set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'  ;
NEW_CONNECTION;
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'		;
NEW_CONNECTION;
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'

;
NEW_CONNECTION;
set   read_only_staleness='MIN_READ_TIMESTAMP   2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
set	read_only_staleness='MIN_READ_TIMESTAMP	2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
set
read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP%2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP_2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP&2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP$2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP@2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP!2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP*2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP(2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP)2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP-2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP+2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP-#2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP/2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP\2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP?2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP-/2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP/#2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP 2018-01-02T03:04:05.123+07:45'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MIN_READ_TIMESTAMP/-2018-01-02T03:04:05.123+07:45';
NEW_CONNECTION;
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
SET READ_ONLY_STALENESS='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
set read_only_staleness='read_timestamp 2018-01-02t03:04:05.54321-07:00';
NEW_CONNECTION;
   set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
			set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;



set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'  ;
NEW_CONNECTION;
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'		;
NEW_CONNECTION;
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'

;
NEW_CONNECTION;
set   read_only_staleness='READ_TIMESTAMP   2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
set	read_only_staleness='READ_TIMESTAMP	2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
set
read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP%2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP_2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP&2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP$2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP@2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP!2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP*2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP(2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP)2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP-2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP+2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP-#2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP/2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP\2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP?2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP-/2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP/#2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321-07:00'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP/-2018-01-02T03:04:05.54321-07:00';
NEW_CONNECTION;
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
SET READ_ONLY_STALENESS='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
set read_only_staleness='read_timestamp 2018-01-02t03:04:05.54321z';
NEW_CONNECTION;
   set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
			set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;



set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'  ;
NEW_CONNECTION;
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'		;
NEW_CONNECTION;
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'

;
NEW_CONNECTION;
set   read_only_staleness='READ_TIMESTAMP   2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
set	read_only_staleness='READ_TIMESTAMP	2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
set
read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP%2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP_2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP&2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP$2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP@2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP!2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP*2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP(2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP)2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP-2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP+2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP-#2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP/2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP\2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP?2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP-/2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP/#2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321Z'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP/-2018-01-02T03:04:05.54321Z';
NEW_CONNECTION;
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
SET READ_ONLY_STALENESS='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
set read_only_staleness='read_timestamp 2018-01-02t03:04:05.54321+05:30';
NEW_CONNECTION;
   set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
			set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;



set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'  ;
NEW_CONNECTION;
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'		;
NEW_CONNECTION;
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'

;
NEW_CONNECTION;
set   read_only_staleness='READ_TIMESTAMP   2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
set	read_only_staleness='READ_TIMESTAMP	2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
set
read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP%2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP_2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP&2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP$2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP@2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP!2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP*2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP(2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP)2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP-2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP+2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP-#2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP/2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP\2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP?2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP-/2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP/#2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP 2018-01-02T03:04:05.54321+05:30'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='READ_TIMESTAMP/-2018-01-02T03:04:05.54321+05:30';
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
SET READ_ONLY_STALENESS='MAX_STALENESS 12S';
NEW_CONNECTION;
set read_only_staleness='max_staleness 12s';
NEW_CONNECTION;
   set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
			set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;



set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 12s'  ;
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 12s'		;
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 12s'

;
NEW_CONNECTION;
set   read_only_staleness='MAX_STALENESS   12s';
NEW_CONNECTION;
set	read_only_staleness='MAX_STALENESS	12s';
NEW_CONNECTION;
set
read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS%12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS_12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS&12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS$12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS@12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS!12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS*12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS(12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS)12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS-12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS+12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS-#12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS/12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS\12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS?12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS-/12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS/#12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_only_staleness='MAX_STALENESS 12s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 12s'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS/-12s';
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
SET READ_ONLY_STALENESS='MAX_STALENESS 100MS';
NEW_CONNECTION;
set read_only_staleness='max_staleness 100ms';
NEW_CONNECTION;
   set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
			set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;



set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 100ms'  ;
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 100ms'		;
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 100ms'

;
NEW_CONNECTION;
set   read_only_staleness='MAX_STALENESS   100ms';
NEW_CONNECTION;
set	read_only_staleness='MAX_STALENESS	100ms';
NEW_CONNECTION;
set
read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS%100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS_100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS&100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS$100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS@100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS!100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS*100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS(100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS)100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS-100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS+100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS-#100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS/100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS\100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS?100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS-/100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS/#100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_only_staleness='MAX_STALENESS 100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 100ms'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS/-100ms';
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
SET READ_ONLY_STALENESS='MAX_STALENESS 99999US';
NEW_CONNECTION;
set read_only_staleness='max_staleness 99999us';
NEW_CONNECTION;
   set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
			set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;



set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 99999us'  ;
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 99999us'		;
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 99999us'

;
NEW_CONNECTION;
set   read_only_staleness='MAX_STALENESS   99999us';
NEW_CONNECTION;
set	read_only_staleness='MAX_STALENESS	99999us';
NEW_CONNECTION;
set
read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS%99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS_99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS&99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS$99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS@99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS!99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS*99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS(99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS)99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS-99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS+99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS-#99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS/99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS\99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS?99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS-/99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS/#99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_only_staleness='MAX_STALENESS 99999us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 99999us'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS/-99999us';
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
SET READ_ONLY_STALENESS='MAX_STALENESS 10NS';
NEW_CONNECTION;
set read_only_staleness='max_staleness 10ns';
NEW_CONNECTION;
   set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
			set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;



set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 10ns'  ;
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 10ns'		;
NEW_CONNECTION;
set read_only_staleness='MAX_STALENESS 10ns'

;
NEW_CONNECTION;
set   read_only_staleness='MAX_STALENESS   10ns';
NEW_CONNECTION;
set	read_only_staleness='MAX_STALENESS	10ns';
NEW_CONNECTION;
set
read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS%10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS_10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS&10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS$10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS@10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS!10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS*10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS(10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS)10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS-10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS+10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS-#10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS/10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS\10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS?10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS-/10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS/#10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_only_staleness='MAX_STALENESS 10ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS 10ns'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='MAX_STALENESS/-10ns';
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
SET READ_ONLY_STALENESS='EXACT_STALENESS 15S';
NEW_CONNECTION;
set read_only_staleness='exact_staleness 15s';
NEW_CONNECTION;
   set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
			set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;



set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 15s'  ;
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 15s'		;
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 15s'

;
NEW_CONNECTION;
set   read_only_staleness='EXACT_STALENESS   15s';
NEW_CONNECTION;
set	read_only_staleness='EXACT_STALENESS	15s';
NEW_CONNECTION;
set
read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS%15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS_15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS&15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS$15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS@15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS!15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS*15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS(15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS)15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS-15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS+15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS-#15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS/15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS\15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS?15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS-/15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS/#15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_only_staleness='EXACT_STALENESS 15s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15s'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS/-15s';
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
SET READ_ONLY_STALENESS='EXACT_STALENESS 1500MS';
NEW_CONNECTION;
set read_only_staleness='exact_staleness 1500ms';
NEW_CONNECTION;
   set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
			set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;



set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 1500ms'  ;
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 1500ms'		;
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 1500ms'

;
NEW_CONNECTION;
set   read_only_staleness='EXACT_STALENESS   1500ms';
NEW_CONNECTION;
set	read_only_staleness='EXACT_STALENESS	1500ms';
NEW_CONNECTION;
set
read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS%1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS_1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS&1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS$1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS@1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS!1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS*1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS(1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS)1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS-1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS+1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS-#1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS/1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS\1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS?1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS-/1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS/#1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_only_staleness='EXACT_STALENESS 1500ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 1500ms'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS/-1500ms';
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
SET READ_ONLY_STALENESS='EXACT_STALENESS 15000000US';
NEW_CONNECTION;
set read_only_staleness='exact_staleness 15000000us';
NEW_CONNECTION;
   set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
			set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;



set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 15000000us'  ;
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 15000000us'		;
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 15000000us'

;
NEW_CONNECTION;
set   read_only_staleness='EXACT_STALENESS   15000000us';
NEW_CONNECTION;
set	read_only_staleness='EXACT_STALENESS	15000000us';
NEW_CONNECTION;
set
read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS%15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS_15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS&15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS$15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS@15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS!15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS*15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS(15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS)15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS-15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS+15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS-#15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS/15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS\15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS?15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS-/15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS/#15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_only_staleness='EXACT_STALENESS 15000000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 15000000us'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS/-15000000us';
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
SET READ_ONLY_STALENESS='EXACT_STALENESS 9999NS';
NEW_CONNECTION;
set read_only_staleness='exact_staleness 9999ns';
NEW_CONNECTION;
   set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
			set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;



set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 9999ns'  ;
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 9999ns'		;
NEW_CONNECTION;
set read_only_staleness='EXACT_STALENESS 9999ns'

;
NEW_CONNECTION;
set   read_only_staleness='EXACT_STALENESS   9999ns';
NEW_CONNECTION;
set	read_only_staleness='EXACT_STALENESS	9999ns';
NEW_CONNECTION;
set
read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS%9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS_9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS&9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS$9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS@9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS!9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS*9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS(9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS)9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS-9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS+9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS-#9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS/9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS\9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS?9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS-/9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS/#9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_only_staleness='EXACT_STALENESS 9999ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS 9999ns'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_only_staleness='EXACT_STALENESS/-9999ns';
NEW_CONNECTION;
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
   set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
			set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;



set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'  ;
NEW_CONNECTION;
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'		;
NEW_CONNECTION;
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'

;
NEW_CONNECTION;
set   directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
set	directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
set
directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-directed_read='{"includeReplicas":{"replicaSelections":[{"location":"eu-west1","type":"READ_ONLY"}]}}';
NEW_CONNECTION;
set directed_read='';
NEW_CONNECTION;
   set directed_read='';
NEW_CONNECTION;
			set directed_read='';
NEW_CONNECTION;



set directed_read='';
NEW_CONNECTION;
set directed_read=''  ;
NEW_CONNECTION;
set directed_read=''		;
NEW_CONNECTION;
set directed_read=''

;
NEW_CONNECTION;
set   directed_read='';
NEW_CONNECTION;
set	directed_read='';
NEW_CONNECTION;
set
directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read='');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set directed_read='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set directed_read=''/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-directed_read='';
NEW_CONNECTION;
set optimizer_version='1';
NEW_CONNECTION;
SET OPTIMIZER_VERSION='1';
NEW_CONNECTION;
set optimizer_version='1';
NEW_CONNECTION;
   set optimizer_version='1';
NEW_CONNECTION;
			set optimizer_version='1';
NEW_CONNECTION;



set optimizer_version='1';
NEW_CONNECTION;
set optimizer_version='1'  ;
NEW_CONNECTION;
set optimizer_version='1'		;
NEW_CONNECTION;
set optimizer_version='1'

;
NEW_CONNECTION;
set   optimizer_version='1';
NEW_CONNECTION;
set	optimizer_version='1';
NEW_CONNECTION;
set
optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set optimizer_version='1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='1'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-optimizer_version='1';
NEW_CONNECTION;
set optimizer_version='200';
NEW_CONNECTION;
SET OPTIMIZER_VERSION='200';
NEW_CONNECTION;
set optimizer_version='200';
NEW_CONNECTION;
   set optimizer_version='200';
NEW_CONNECTION;
			set optimizer_version='200';
NEW_CONNECTION;



set optimizer_version='200';
NEW_CONNECTION;
set optimizer_version='200'  ;
NEW_CONNECTION;
set optimizer_version='200'		;
NEW_CONNECTION;
set optimizer_version='200'

;
NEW_CONNECTION;
set   optimizer_version='200';
NEW_CONNECTION;
set	optimizer_version='200';
NEW_CONNECTION;
set
optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set optimizer_version='200';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='200'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-optimizer_version='200';
NEW_CONNECTION;
set optimizer_version='LATEST';
NEW_CONNECTION;
SET OPTIMIZER_VERSION='LATEST';
NEW_CONNECTION;
set optimizer_version='latest';
NEW_CONNECTION;
   set optimizer_version='LATEST';
NEW_CONNECTION;
			set optimizer_version='LATEST';
NEW_CONNECTION;



set optimizer_version='LATEST';
NEW_CONNECTION;
set optimizer_version='LATEST'  ;
NEW_CONNECTION;
set optimizer_version='LATEST'		;
NEW_CONNECTION;
set optimizer_version='LATEST'

;
NEW_CONNECTION;
set   optimizer_version='LATEST';
NEW_CONNECTION;
set	optimizer_version='LATEST';
NEW_CONNECTION;
set
optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set optimizer_version='LATEST';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='LATEST'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-optimizer_version='LATEST';
NEW_CONNECTION;
set optimizer_version='';
NEW_CONNECTION;
SET OPTIMIZER_VERSION='';
NEW_CONNECTION;
set optimizer_version='';
NEW_CONNECTION;
   set optimizer_version='';
NEW_CONNECTION;
			set optimizer_version='';
NEW_CONNECTION;



set optimizer_version='';
NEW_CONNECTION;
set optimizer_version=''  ;
NEW_CONNECTION;
set optimizer_version=''		;
NEW_CONNECTION;
set optimizer_version=''

;
NEW_CONNECTION;
set   optimizer_version='';
NEW_CONNECTION;
set	optimizer_version='';
NEW_CONNECTION;
set
optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version='');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set optimizer_version='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_version=''/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-optimizer_version='';
NEW_CONNECTION;
set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
SET OPTIMIZER_STATISTICS_PACKAGE='AUTO_20191128_14_47_22UTC';
NEW_CONNECTION;
set optimizer_statistics_package='auto_20191128_14_47_22utc';
NEW_CONNECTION;
   set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
			set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;



set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
set optimizer_statistics_package='auto_20191128_14_47_22UTC'  ;
NEW_CONNECTION;
set optimizer_statistics_package='auto_20191128_14_47_22UTC'		;
NEW_CONNECTION;
set optimizer_statistics_package='auto_20191128_14_47_22UTC'

;
NEW_CONNECTION;
set   optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
set	optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
set
optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='auto_20191128_14_47_22UTC'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-optimizer_statistics_package='auto_20191128_14_47_22UTC';
NEW_CONNECTION;
set optimizer_statistics_package='';
NEW_CONNECTION;
SET OPTIMIZER_STATISTICS_PACKAGE='';
NEW_CONNECTION;
set optimizer_statistics_package='';
NEW_CONNECTION;
   set optimizer_statistics_package='';
NEW_CONNECTION;
			set optimizer_statistics_package='';
NEW_CONNECTION;



set optimizer_statistics_package='';
NEW_CONNECTION;
set optimizer_statistics_package=''  ;
NEW_CONNECTION;
set optimizer_statistics_package=''		;
NEW_CONNECTION;
set optimizer_statistics_package=''

;
NEW_CONNECTION;
set   optimizer_statistics_package='';
NEW_CONNECTION;
set	optimizer_statistics_package='';
NEW_CONNECTION;
set
optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package='');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set optimizer_statistics_package='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set optimizer_statistics_package=''/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-optimizer_statistics_package='';
NEW_CONNECTION;
set return_commit_stats = true;
NEW_CONNECTION;
SET RETURN_COMMIT_STATS = TRUE;
NEW_CONNECTION;
set return_commit_stats = true;
NEW_CONNECTION;
   set return_commit_stats = true;
NEW_CONNECTION;
			set return_commit_stats = true;
NEW_CONNECTION;



set return_commit_stats = true;
NEW_CONNECTION;
set return_commit_stats = true  ;
NEW_CONNECTION;
set return_commit_stats = true		;
NEW_CONNECTION;
set return_commit_stats = true

;
NEW_CONNECTION;
set   return_commit_stats   =   true;
NEW_CONNECTION;
set	return_commit_stats	=	true;
NEW_CONNECTION;
set
return_commit_stats
=
true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =%true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =_true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =&true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =$true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =@true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =!true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =*true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =(true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =)true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =-true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =+true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =-#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =\true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =?true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =-/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =/#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set return_commit_stats = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = true/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =/-true;
NEW_CONNECTION;
set return_commit_stats = false;
NEW_CONNECTION;
SET RETURN_COMMIT_STATS = FALSE;
NEW_CONNECTION;
set return_commit_stats = false;
NEW_CONNECTION;
   set return_commit_stats = false;
NEW_CONNECTION;
			set return_commit_stats = false;
NEW_CONNECTION;



set return_commit_stats = false;
NEW_CONNECTION;
set return_commit_stats = false  ;
NEW_CONNECTION;
set return_commit_stats = false		;
NEW_CONNECTION;
set return_commit_stats = false

;
NEW_CONNECTION;
set   return_commit_stats   =   false;
NEW_CONNECTION;
set	return_commit_stats	=	false;
NEW_CONNECTION;
set
return_commit_stats
=
false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =%false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =_false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =&false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =$false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =@false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =!false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =*false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =(false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =)false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =-false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =+false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =-#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =\false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =?false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =-/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =/#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set return_commit_stats = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats = false/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set return_commit_stats =/-false;
NEW_CONNECTION;
set max_commit_delay=null;
NEW_CONNECTION;
SET MAX_COMMIT_DELAY=NULL;
NEW_CONNECTION;
set max_commit_delay=null;
NEW_CONNECTION;
   set max_commit_delay=null;
NEW_CONNECTION;
			set max_commit_delay=null;
NEW_CONNECTION;



set max_commit_delay=null;
NEW_CONNECTION;
set max_commit_delay=null  ;
NEW_CONNECTION;
set max_commit_delay=null		;
NEW_CONNECTION;
set max_commit_delay=null

;
NEW_CONNECTION;
set   max_commit_delay=null;
NEW_CONNECTION;
set	max_commit_delay=null;
NEW_CONNECTION;
set
max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_commit_delay=null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=null/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-max_commit_delay=null;
NEW_CONNECTION;
set max_commit_delay = null;
NEW_CONNECTION;
SET MAX_COMMIT_DELAY = NULL;
NEW_CONNECTION;
set max_commit_delay = null;
NEW_CONNECTION;
   set max_commit_delay = null;
NEW_CONNECTION;
			set max_commit_delay = null;
NEW_CONNECTION;



set max_commit_delay = null;
NEW_CONNECTION;
set max_commit_delay = null  ;
NEW_CONNECTION;
set max_commit_delay = null		;
NEW_CONNECTION;
set max_commit_delay = null

;
NEW_CONNECTION;
set   max_commit_delay   =   null;
NEW_CONNECTION;
set	max_commit_delay	=	null;
NEW_CONNECTION;
set
max_commit_delay
=
null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =%null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =_null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =&null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =$null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =@null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =!null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =*null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =(null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =)null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =-null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =+null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =-#null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =/null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =\null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =?null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =-/null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =/#null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_commit_delay = null;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =/-null;
NEW_CONNECTION;
set max_commit_delay = null ;
NEW_CONNECTION;
SET MAX_COMMIT_DELAY = NULL ;
NEW_CONNECTION;
set max_commit_delay = null ;
NEW_CONNECTION;
   set max_commit_delay = null ;
NEW_CONNECTION;
			set max_commit_delay = null ;
NEW_CONNECTION;



set max_commit_delay = null ;
NEW_CONNECTION;
set max_commit_delay = null   ;
NEW_CONNECTION;
set max_commit_delay = null 		;
NEW_CONNECTION;
set max_commit_delay = null 

;
NEW_CONNECTION;
set   max_commit_delay   =   null   ;
NEW_CONNECTION;
set	max_commit_delay	=	null	;
NEW_CONNECTION;
set
max_commit_delay
=
null
;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null  bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null %;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null _;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null &;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null $;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null @;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null !;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null *;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null (;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null );
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null -;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null +;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null -#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null /;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null \;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null ?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null -/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null /#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_commit_delay = null ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null /-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = null/-;
NEW_CONNECTION;
set max_commit_delay=1000;
NEW_CONNECTION;
SET MAX_COMMIT_DELAY=1000;
NEW_CONNECTION;
set max_commit_delay=1000;
NEW_CONNECTION;
   set max_commit_delay=1000;
NEW_CONNECTION;
			set max_commit_delay=1000;
NEW_CONNECTION;



set max_commit_delay=1000;
NEW_CONNECTION;
set max_commit_delay=1000  ;
NEW_CONNECTION;
set max_commit_delay=1000		;
NEW_CONNECTION;
set max_commit_delay=1000

;
NEW_CONNECTION;
set   max_commit_delay=1000;
NEW_CONNECTION;
set	max_commit_delay=1000;
NEW_CONNECTION;
set
max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000 bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_commit_delay=1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay=1000/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-max_commit_delay=1000;
NEW_CONNECTION;
set max_commit_delay = 1000;
NEW_CONNECTION;
SET MAX_COMMIT_DELAY = 1000;
NEW_CONNECTION;
set max_commit_delay = 1000;
NEW_CONNECTION;
   set max_commit_delay = 1000;
NEW_CONNECTION;
			set max_commit_delay = 1000;
NEW_CONNECTION;



set max_commit_delay = 1000;
NEW_CONNECTION;
set max_commit_delay = 1000  ;
NEW_CONNECTION;
set max_commit_delay = 1000		;
NEW_CONNECTION;
set max_commit_delay = 1000

;
NEW_CONNECTION;
set   max_commit_delay   =   1000;
NEW_CONNECTION;
set	max_commit_delay	=	1000;
NEW_CONNECTION;
set
max_commit_delay
=
1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =%1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =_1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =&1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =$1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =@1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =!1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =*1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =(1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =)1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =-1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =+1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =-#1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =/1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =\1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =?1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =-/1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =/#1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_commit_delay = 1000;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =/-1000;
NEW_CONNECTION;
set max_commit_delay = 1000 ;
NEW_CONNECTION;
SET MAX_COMMIT_DELAY = 1000 ;
NEW_CONNECTION;
set max_commit_delay = 1000 ;
NEW_CONNECTION;
   set max_commit_delay = 1000 ;
NEW_CONNECTION;
			set max_commit_delay = 1000 ;
NEW_CONNECTION;



set max_commit_delay = 1000 ;
NEW_CONNECTION;
set max_commit_delay = 1000   ;
NEW_CONNECTION;
set max_commit_delay = 1000 		;
NEW_CONNECTION;
set max_commit_delay = 1000 

;
NEW_CONNECTION;
set   max_commit_delay   =   1000   ;
NEW_CONNECTION;
set	max_commit_delay	=	1000	;
NEW_CONNECTION;
set
max_commit_delay
=
1000
;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000  bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 %;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 _;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 &;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 $;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 @;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 !;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 *;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 (;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 );
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 -;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 +;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 -#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 /;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 \;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 ?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 -/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 /#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_commit_delay = 1000 ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000 /-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = 1000/-;
NEW_CONNECTION;
set max_commit_delay='1s';
NEW_CONNECTION;
SET MAX_COMMIT_DELAY='1S';
NEW_CONNECTION;
set max_commit_delay='1s';
NEW_CONNECTION;
   set max_commit_delay='1s';
NEW_CONNECTION;
			set max_commit_delay='1s';
NEW_CONNECTION;



set max_commit_delay='1s';
NEW_CONNECTION;
set max_commit_delay='1s'  ;
NEW_CONNECTION;
set max_commit_delay='1s'		;
NEW_CONNECTION;
set max_commit_delay='1s'

;
NEW_CONNECTION;
set   max_commit_delay='1s';
NEW_CONNECTION;
set	max_commit_delay='1s';
NEW_CONNECTION;
set
max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_commit_delay='1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='1s'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-max_commit_delay='1s';
NEW_CONNECTION;
set max_commit_delay = '1s';
NEW_CONNECTION;
SET MAX_COMMIT_DELAY = '1S';
NEW_CONNECTION;
set max_commit_delay = '1s';
NEW_CONNECTION;
   set max_commit_delay = '1s';
NEW_CONNECTION;
			set max_commit_delay = '1s';
NEW_CONNECTION;



set max_commit_delay = '1s';
NEW_CONNECTION;
set max_commit_delay = '1s'  ;
NEW_CONNECTION;
set max_commit_delay = '1s'		;
NEW_CONNECTION;
set max_commit_delay = '1s'

;
NEW_CONNECTION;
set   max_commit_delay   =   '1s';
NEW_CONNECTION;
set	max_commit_delay	=	'1s';
NEW_CONNECTION;
set
max_commit_delay
=
'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =%'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =_'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =&'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =$'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =@'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =!'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =*'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =('1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =)'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =-'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =+'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =-#'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =/'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =\'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =?'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =-/'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =/#'1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_commit_delay = '1s';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay =/-'1s';
NEW_CONNECTION;
set max_commit_delay = '1s' ;
NEW_CONNECTION;
SET MAX_COMMIT_DELAY = '1S' ;
NEW_CONNECTION;
set max_commit_delay = '1s' ;
NEW_CONNECTION;
   set max_commit_delay = '1s' ;
NEW_CONNECTION;
			set max_commit_delay = '1s' ;
NEW_CONNECTION;



set max_commit_delay = '1s' ;
NEW_CONNECTION;
set max_commit_delay = '1s'   ;
NEW_CONNECTION;
set max_commit_delay = '1s' 		;
NEW_CONNECTION;
set max_commit_delay = '1s' 

;
NEW_CONNECTION;
set   max_commit_delay   =   '1s'   ;
NEW_CONNECTION;
set	max_commit_delay	=	'1s'	;
NEW_CONNECTION;
set
max_commit_delay
=
'1s'
;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'  bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' %;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' _;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' &;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' $;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' @;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' !;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' *;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' (;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' );
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' -;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' +;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' -#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' /;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' \;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' ?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' -/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' /#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_commit_delay = '1s' ;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s' /-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay = '1s'/-;
NEW_CONNECTION;
set max_commit_delay='100ms';
NEW_CONNECTION;
SET MAX_COMMIT_DELAY='100MS';
NEW_CONNECTION;
set max_commit_delay='100ms';
NEW_CONNECTION;
   set max_commit_delay='100ms';
NEW_CONNECTION;
			set max_commit_delay='100ms';
NEW_CONNECTION;



set max_commit_delay='100ms';
NEW_CONNECTION;
set max_commit_delay='100ms'  ;
NEW_CONNECTION;
set max_commit_delay='100ms'		;
NEW_CONNECTION;
set max_commit_delay='100ms'

;
NEW_CONNECTION;
set   max_commit_delay='100ms';
NEW_CONNECTION;
set	max_commit_delay='100ms';
NEW_CONNECTION;
set
max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_commit_delay='100ms';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='100ms'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-max_commit_delay='100ms';
NEW_CONNECTION;
set max_commit_delay='10000us';
NEW_CONNECTION;
SET MAX_COMMIT_DELAY='10000US';
NEW_CONNECTION;
set max_commit_delay='10000us';
NEW_CONNECTION;
   set max_commit_delay='10000us';
NEW_CONNECTION;
			set max_commit_delay='10000us';
NEW_CONNECTION;



set max_commit_delay='10000us';
NEW_CONNECTION;
set max_commit_delay='10000us'  ;
NEW_CONNECTION;
set max_commit_delay='10000us'		;
NEW_CONNECTION;
set max_commit_delay='10000us'

;
NEW_CONNECTION;
set   max_commit_delay='10000us';
NEW_CONNECTION;
set	max_commit_delay='10000us';
NEW_CONNECTION;
set
max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_commit_delay='10000us';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='10000us'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-max_commit_delay='10000us';
NEW_CONNECTION;
set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
SET MAX_COMMIT_DELAY='9223372036854775807NS';
NEW_CONNECTION;
set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
   set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
			set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;



set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
set max_commit_delay='9223372036854775807ns'  ;
NEW_CONNECTION;
set max_commit_delay='9223372036854775807ns'		;
NEW_CONNECTION;
set max_commit_delay='9223372036854775807ns'

;
NEW_CONNECTION;
set   max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
set	max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
set
max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_commit_delay='9223372036854775807ns'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-max_commit_delay='9223372036854775807ns';
NEW_CONNECTION;
set statement_tag='tag1';
NEW_CONNECTION;
SET STATEMENT_TAG='TAG1';
NEW_CONNECTION;
set statement_tag='tag1';
NEW_CONNECTION;
   set statement_tag='tag1';
NEW_CONNECTION;
			set statement_tag='tag1';
NEW_CONNECTION;



set statement_tag='tag1';
NEW_CONNECTION;
set statement_tag='tag1'  ;
NEW_CONNECTION;
set statement_tag='tag1'		;
NEW_CONNECTION;
set statement_tag='tag1'

;
NEW_CONNECTION;
set   statement_tag='tag1';
NEW_CONNECTION;
set	statement_tag='tag1';
NEW_CONNECTION;
set
statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set statement_tag='tag1';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag1'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-statement_tag='tag1';
NEW_CONNECTION;
set statement_tag='tag2';
NEW_CONNECTION;
SET STATEMENT_TAG='TAG2';
NEW_CONNECTION;
set statement_tag='tag2';
NEW_CONNECTION;
   set statement_tag='tag2';
NEW_CONNECTION;
			set statement_tag='tag2';
NEW_CONNECTION;



set statement_tag='tag2';
NEW_CONNECTION;
set statement_tag='tag2'  ;
NEW_CONNECTION;
set statement_tag='tag2'		;
NEW_CONNECTION;
set statement_tag='tag2'

;
NEW_CONNECTION;
set   statement_tag='tag2';
NEW_CONNECTION;
set	statement_tag='tag2';
NEW_CONNECTION;
set
statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set statement_tag='tag2';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='tag2'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-statement_tag='tag2';
NEW_CONNECTION;
set statement_tag='';
NEW_CONNECTION;
SET STATEMENT_TAG='';
NEW_CONNECTION;
set statement_tag='';
NEW_CONNECTION;
   set statement_tag='';
NEW_CONNECTION;
			set statement_tag='';
NEW_CONNECTION;



set statement_tag='';
NEW_CONNECTION;
set statement_tag=''  ;
NEW_CONNECTION;
set statement_tag=''		;
NEW_CONNECTION;
set statement_tag=''

;
NEW_CONNECTION;
set   statement_tag='';
NEW_CONNECTION;
set	statement_tag='';
NEW_CONNECTION;
set
statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set statement_tag='';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag=''/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-statement_tag='';
NEW_CONNECTION;
set statement_tag='test_tag';
NEW_CONNECTION;
SET STATEMENT_TAG='TEST_TAG';
NEW_CONNECTION;
set statement_tag='test_tag';
NEW_CONNECTION;
   set statement_tag='test_tag';
NEW_CONNECTION;
			set statement_tag='test_tag';
NEW_CONNECTION;



set statement_tag='test_tag';
NEW_CONNECTION;
set statement_tag='test_tag'  ;
NEW_CONNECTION;
set statement_tag='test_tag'		;
NEW_CONNECTION;
set statement_tag='test_tag'

;
NEW_CONNECTION;
set   statement_tag='test_tag';
NEW_CONNECTION;
set	statement_tag='test_tag';
NEW_CONNECTION;
set
statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set statement_tag='test_tag';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set statement_tag='test_tag'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-statement_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
SET TRANSACTION_TAG='TAG1';
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
   set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
			set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;



set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='tag1'  ;
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='tag1'		;
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='tag1'

;
NEW_CONNECTION;
set autocommit = false;
set   transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
set	transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
set
transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1' bar;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'%;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'_;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'&;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'$;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'@;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'!;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'*;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'(;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1');
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'-;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'+;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'-#;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'/;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'\;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'?;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'-/;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'/#;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag1'/-;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-transaction_tag='tag1';
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
SET TRANSACTION_TAG='TAG2';
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
   set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
			set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;



set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='tag2'  ;
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='tag2'		;
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='tag2'

;
NEW_CONNECTION;
set autocommit = false;
set   transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
set	transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
set
transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2' bar;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'%;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'_;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'&;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'$;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'@;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'!;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'*;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'(;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2');
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'-;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'+;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'-#;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'/;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'\;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'?;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'-/;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'/#;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='tag2'/-;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-transaction_tag='tag2';
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
SET TRANSACTION_TAG='';
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
   set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
			set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;



set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
set transaction_tag=''  ;
NEW_CONNECTION;
set autocommit = false;
set transaction_tag=''		;
NEW_CONNECTION;
set autocommit = false;
set transaction_tag=''

;
NEW_CONNECTION;
set autocommit = false;
set   transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
set	transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
set
transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='' bar;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''%;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''_;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''&;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''$;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''@;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''!;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''*;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''(;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='');
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''-;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''+;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''-#;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''/;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''\;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''?;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''-/;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''/#;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag=''/-;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-transaction_tag='';
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
SET TRANSACTION_TAG='TEST_TAG';
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
   set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
			set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;



set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='test_tag'  ;
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='test_tag'		;
NEW_CONNECTION;
set autocommit = false;
set transaction_tag='test_tag'

;
NEW_CONNECTION;
set autocommit = false;
set   transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
set	transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
set
transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag' bar;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'%;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'_;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'&;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'$;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'@;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'!;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'*;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'(;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag');
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'-;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'+;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'-#;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'/;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'\;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'?;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'-/;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'/#;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set transaction_tag='test_tag';
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set transaction_tag='test_tag'/-;
NEW_CONNECTION;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-transaction_tag='test_tag';
NEW_CONNECTION;
set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
SET EXCLUDE_TXN_FROM_CHANGE_STREAMS = TRUE;
NEW_CONNECTION;
set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
   set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
			set exclude_txn_from_change_streams = true;
NEW_CONNECTION;



set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
set exclude_txn_from_change_streams = true  ;
NEW_CONNECTION;
set exclude_txn_from_change_streams = true		;
NEW_CONNECTION;
set exclude_txn_from_change_streams = true

;
NEW_CONNECTION;
set   exclude_txn_from_change_streams   =   true;
NEW_CONNECTION;
set	exclude_txn_from_change_streams	=	true;
NEW_CONNECTION;
set
exclude_txn_from_change_streams
=
true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =%true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =_true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =&true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =$true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =@true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =!true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =*true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =(true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =)true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =-true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =+true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =-#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =\true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =?true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =-/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =/#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set exclude_txn_from_change_streams = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = true/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =/-true;
NEW_CONNECTION;
set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
SET EXCLUDE_TXN_FROM_CHANGE_STREAMS = FALSE;
NEW_CONNECTION;
set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
   set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
			set exclude_txn_from_change_streams = false;
NEW_CONNECTION;



set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
set exclude_txn_from_change_streams = false  ;
NEW_CONNECTION;
set exclude_txn_from_change_streams = false		;
NEW_CONNECTION;
set exclude_txn_from_change_streams = false

;
NEW_CONNECTION;
set   exclude_txn_from_change_streams   =   false;
NEW_CONNECTION;
set	exclude_txn_from_change_streams	=	false;
NEW_CONNECTION;
set
exclude_txn_from_change_streams
=
false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =%false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =_false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =&false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =$false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =@false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =!false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =*false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =(false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =)false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =-false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =+false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =-#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =\false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =?false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =-/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =/#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set exclude_txn_from_change_streams = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams = false/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set exclude_txn_from_change_streams =/-false;
NEW_CONNECTION;
set rpc_priority='HIGH';
NEW_CONNECTION;
SET RPC_PRIORITY='HIGH';
NEW_CONNECTION;
set rpc_priority='high';
NEW_CONNECTION;
   set rpc_priority='HIGH';
NEW_CONNECTION;
			set rpc_priority='HIGH';
NEW_CONNECTION;



set rpc_priority='HIGH';
NEW_CONNECTION;
set rpc_priority='HIGH'  ;
NEW_CONNECTION;
set rpc_priority='HIGH'		;
NEW_CONNECTION;
set rpc_priority='HIGH'

;
NEW_CONNECTION;
set   rpc_priority='HIGH';
NEW_CONNECTION;
set	rpc_priority='HIGH';
NEW_CONNECTION;
set
rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set rpc_priority='HIGH';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='HIGH'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-rpc_priority='HIGH';
NEW_CONNECTION;
set rpc_priority='MEDIUM';
NEW_CONNECTION;
SET RPC_PRIORITY='MEDIUM';
NEW_CONNECTION;
set rpc_priority='medium';
NEW_CONNECTION;
   set rpc_priority='MEDIUM';
NEW_CONNECTION;
			set rpc_priority='MEDIUM';
NEW_CONNECTION;



set rpc_priority='MEDIUM';
NEW_CONNECTION;
set rpc_priority='MEDIUM'  ;
NEW_CONNECTION;
set rpc_priority='MEDIUM'		;
NEW_CONNECTION;
set rpc_priority='MEDIUM'

;
NEW_CONNECTION;
set   rpc_priority='MEDIUM';
NEW_CONNECTION;
set	rpc_priority='MEDIUM';
NEW_CONNECTION;
set
rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set rpc_priority='MEDIUM';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='MEDIUM'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-rpc_priority='MEDIUM';
NEW_CONNECTION;
set rpc_priority='LOW';
NEW_CONNECTION;
SET RPC_PRIORITY='LOW';
NEW_CONNECTION;
set rpc_priority='low';
NEW_CONNECTION;
   set rpc_priority='LOW';
NEW_CONNECTION;
			set rpc_priority='LOW';
NEW_CONNECTION;



set rpc_priority='LOW';
NEW_CONNECTION;
set rpc_priority='LOW'  ;
NEW_CONNECTION;
set rpc_priority='LOW'		;
NEW_CONNECTION;
set rpc_priority='LOW'

;
NEW_CONNECTION;
set   rpc_priority='LOW';
NEW_CONNECTION;
set	rpc_priority='LOW';
NEW_CONNECTION;
set
rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set rpc_priority='LOW';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='LOW'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-rpc_priority='LOW';
NEW_CONNECTION;
set rpc_priority='NULL';
NEW_CONNECTION;
SET RPC_PRIORITY='NULL';
NEW_CONNECTION;
set rpc_priority='null';
NEW_CONNECTION;
   set rpc_priority='NULL';
NEW_CONNECTION;
			set rpc_priority='NULL';
NEW_CONNECTION;



set rpc_priority='NULL';
NEW_CONNECTION;
set rpc_priority='NULL'  ;
NEW_CONNECTION;
set rpc_priority='NULL'		;
NEW_CONNECTION;
set rpc_priority='NULL'

;
NEW_CONNECTION;
set   rpc_priority='NULL';
NEW_CONNECTION;
set	rpc_priority='NULL';
NEW_CONNECTION;
set
rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set rpc_priority='NULL';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set rpc_priority='NULL'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-rpc_priority='NULL';
NEW_CONNECTION;
set savepoint_support='ENABLED';
NEW_CONNECTION;
SET SAVEPOINT_SUPPORT='ENABLED';
NEW_CONNECTION;
set savepoint_support='enabled';
NEW_CONNECTION;
   set savepoint_support='ENABLED';
NEW_CONNECTION;
			set savepoint_support='ENABLED';
NEW_CONNECTION;



set savepoint_support='ENABLED';
NEW_CONNECTION;
set savepoint_support='ENABLED'  ;
NEW_CONNECTION;
set savepoint_support='ENABLED'		;
NEW_CONNECTION;
set savepoint_support='ENABLED'

;
NEW_CONNECTION;
set   savepoint_support='ENABLED';
NEW_CONNECTION;
set	savepoint_support='ENABLED';
NEW_CONNECTION;
set
savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set savepoint_support='ENABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='ENABLED'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-savepoint_support='ENABLED';
NEW_CONNECTION;
set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
SET SAVEPOINT_SUPPORT='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
set savepoint_support='fail_after_rollback';
NEW_CONNECTION;
   set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
			set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;



set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
set savepoint_support='FAIL_AFTER_ROLLBACK'  ;
NEW_CONNECTION;
set savepoint_support='FAIL_AFTER_ROLLBACK'		;
NEW_CONNECTION;
set savepoint_support='FAIL_AFTER_ROLLBACK'

;
NEW_CONNECTION;
set   savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
set	savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
set
savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='FAIL_AFTER_ROLLBACK'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-savepoint_support='FAIL_AFTER_ROLLBACK';
NEW_CONNECTION;
set savepoint_support='DISABLED';
NEW_CONNECTION;
SET SAVEPOINT_SUPPORT='DISABLED';
NEW_CONNECTION;
set savepoint_support='disabled';
NEW_CONNECTION;
   set savepoint_support='DISABLED';
NEW_CONNECTION;
			set savepoint_support='DISABLED';
NEW_CONNECTION;



set savepoint_support='DISABLED';
NEW_CONNECTION;
set savepoint_support='DISABLED'  ;
NEW_CONNECTION;
set savepoint_support='DISABLED'		;
NEW_CONNECTION;
set savepoint_support='DISABLED'

;
NEW_CONNECTION;
set   savepoint_support='DISABLED';
NEW_CONNECTION;
set	savepoint_support='DISABLED';
NEW_CONNECTION;
set
savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set savepoint_support='DISABLED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set savepoint_support='DISABLED'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-savepoint_support='DISABLED';
NEW_CONNECTION;
set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
SET DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE = TRUE;
NEW_CONNECTION;
set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
   set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
			set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;



set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
set delay_transaction_start_until_first_write = true  ;
NEW_CONNECTION;
set delay_transaction_start_until_first_write = true		;
NEW_CONNECTION;
set delay_transaction_start_until_first_write = true

;
NEW_CONNECTION;
set   delay_transaction_start_until_first_write   =   true;
NEW_CONNECTION;
set	delay_transaction_start_until_first_write	=	true;
NEW_CONNECTION;
set
delay_transaction_start_until_first_write
=
true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =%true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =_true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =&true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =$true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =@true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =!true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =*true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =(true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =)true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =-true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =+true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =-#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =\true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =?true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =-/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =/#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set delay_transaction_start_until_first_write = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = true/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =/-true;
NEW_CONNECTION;
set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
SET DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE = FALSE;
NEW_CONNECTION;
set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
   set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
			set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;



set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
set delay_transaction_start_until_first_write = false  ;
NEW_CONNECTION;
set delay_transaction_start_until_first_write = false		;
NEW_CONNECTION;
set delay_transaction_start_until_first_write = false

;
NEW_CONNECTION;
set   delay_transaction_start_until_first_write   =   false;
NEW_CONNECTION;
set	delay_transaction_start_until_first_write	=	false;
NEW_CONNECTION;
set
delay_transaction_start_until_first_write
=
false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =%false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =_false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =&false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =$false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =@false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =!false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =*false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =(false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =)false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =-false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =+false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =-#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =\false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =?false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =-/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =/#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set delay_transaction_start_until_first_write = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write = false/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set delay_transaction_start_until_first_write =/-false;
NEW_CONNECTION;
set keep_transaction_alive = true;
NEW_CONNECTION;
SET KEEP_TRANSACTION_ALIVE = TRUE;
NEW_CONNECTION;
set keep_transaction_alive = true;
NEW_CONNECTION;
   set keep_transaction_alive = true;
NEW_CONNECTION;
			set keep_transaction_alive = true;
NEW_CONNECTION;



set keep_transaction_alive = true;
NEW_CONNECTION;
set keep_transaction_alive = true  ;
NEW_CONNECTION;
set keep_transaction_alive = true		;
NEW_CONNECTION;
set keep_transaction_alive = true

;
NEW_CONNECTION;
set   keep_transaction_alive   =   true;
NEW_CONNECTION;
set	keep_transaction_alive	=	true;
NEW_CONNECTION;
set
keep_transaction_alive
=
true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =%true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =_true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =&true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =$true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =@true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =!true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =*true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =(true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =)true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =-true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =+true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =-#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =\true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =?true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =-/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =/#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set keep_transaction_alive = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = true/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =/-true;
NEW_CONNECTION;
set keep_transaction_alive = false;
NEW_CONNECTION;
SET KEEP_TRANSACTION_ALIVE = FALSE;
NEW_CONNECTION;
set keep_transaction_alive = false;
NEW_CONNECTION;
   set keep_transaction_alive = false;
NEW_CONNECTION;
			set keep_transaction_alive = false;
NEW_CONNECTION;



set keep_transaction_alive = false;
NEW_CONNECTION;
set keep_transaction_alive = false  ;
NEW_CONNECTION;
set keep_transaction_alive = false		;
NEW_CONNECTION;
set keep_transaction_alive = false

;
NEW_CONNECTION;
set   keep_transaction_alive   =   false;
NEW_CONNECTION;
set	keep_transaction_alive	=	false;
NEW_CONNECTION;
set
keep_transaction_alive
=
false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =%false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =_false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =&false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =$false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =@false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =!false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =*false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =(false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =)false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =-false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =+false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =-#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =\false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =?false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =-/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =/#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set keep_transaction_alive = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive = false/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set keep_transaction_alive =/-false;
NEW_CONNECTION;
set auto_batch_dml = true;
NEW_CONNECTION;
SET AUTO_BATCH_DML = TRUE;
NEW_CONNECTION;
set auto_batch_dml = true;
NEW_CONNECTION;
   set auto_batch_dml = true;
NEW_CONNECTION;
			set auto_batch_dml = true;
NEW_CONNECTION;



set auto_batch_dml = true;
NEW_CONNECTION;
set auto_batch_dml = true  ;
NEW_CONNECTION;
set auto_batch_dml = true		;
NEW_CONNECTION;
set auto_batch_dml = true

;
NEW_CONNECTION;
set   auto_batch_dml   =   true;
NEW_CONNECTION;
set	auto_batch_dml	=	true;
NEW_CONNECTION;
set
auto_batch_dml
=
true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =%true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =_true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =&true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =$true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =@true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =!true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =*true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =(true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =)true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =-true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =+true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =-#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =\true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =?true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =-/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =/#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set auto_batch_dml = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = true/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =/-true;
NEW_CONNECTION;
set auto_batch_dml = false;
NEW_CONNECTION;
SET AUTO_BATCH_DML = FALSE;
NEW_CONNECTION;
set auto_batch_dml = false;
NEW_CONNECTION;
   set auto_batch_dml = false;
NEW_CONNECTION;
			set auto_batch_dml = false;
NEW_CONNECTION;



set auto_batch_dml = false;
NEW_CONNECTION;
set auto_batch_dml = false  ;
NEW_CONNECTION;
set auto_batch_dml = false		;
NEW_CONNECTION;
set auto_batch_dml = false

;
NEW_CONNECTION;
set   auto_batch_dml   =   false;
NEW_CONNECTION;
set	auto_batch_dml	=	false;
NEW_CONNECTION;
set
auto_batch_dml
=
false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =%false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =_false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =&false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =$false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =@false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =!false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =*false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =(false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =)false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =-false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =+false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =-#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =\false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =?false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =-/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =/#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set auto_batch_dml = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml = false/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml =/-false;
NEW_CONNECTION;
set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
SET AUTO_BATCH_DML_UPDATE_COUNT = 0;
NEW_CONNECTION;
set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
   set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
			set auto_batch_dml_update_count = 0;
NEW_CONNECTION;



set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
set auto_batch_dml_update_count = 0  ;
NEW_CONNECTION;
set auto_batch_dml_update_count = 0		;
NEW_CONNECTION;
set auto_batch_dml_update_count = 0

;
NEW_CONNECTION;
set   auto_batch_dml_update_count   =   0;
NEW_CONNECTION;
set	auto_batch_dml_update_count	=	0;
NEW_CONNECTION;
set
auto_batch_dml_update_count
=
0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0 bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =%0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =_0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =&0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =$0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =@0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =!0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =*0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =(0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =)0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =-0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =+0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =-#0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =/0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =\0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =?0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =-/0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =/#0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set auto_batch_dml_update_count = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 0/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =/-0;
NEW_CONNECTION;
set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
SET AUTO_BATCH_DML_UPDATE_COUNT = 100;
NEW_CONNECTION;
set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
   set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
			set auto_batch_dml_update_count = 100;
NEW_CONNECTION;



set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
set auto_batch_dml_update_count = 100  ;
NEW_CONNECTION;
set auto_batch_dml_update_count = 100		;
NEW_CONNECTION;
set auto_batch_dml_update_count = 100

;
NEW_CONNECTION;
set   auto_batch_dml_update_count   =   100;
NEW_CONNECTION;
set	auto_batch_dml_update_count	=	100;
NEW_CONNECTION;
set
auto_batch_dml_update_count
=
100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100 bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =%100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =_100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =&100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =$100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =@100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =!100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =*100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =(100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =)100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =-100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =+100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =-#100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =/100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =\100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =?100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =-/100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =/#100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set auto_batch_dml_update_count = 100;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count = 100/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count =/-100;
NEW_CONNECTION;
set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
SET AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION = TRUE;
NEW_CONNECTION;
set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
   set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
			set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;



set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
set auto_batch_dml_update_count_verification = true  ;
NEW_CONNECTION;
set auto_batch_dml_update_count_verification = true		;
NEW_CONNECTION;
set auto_batch_dml_update_count_verification = true

;
NEW_CONNECTION;
set   auto_batch_dml_update_count_verification   =   true;
NEW_CONNECTION;
set	auto_batch_dml_update_count_verification	=	true;
NEW_CONNECTION;
set
auto_batch_dml_update_count_verification
=
true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =%true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =_true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =&true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =$true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =@true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =!true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =*true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =(true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =)true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =-true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =+true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =-#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =\true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =?true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =-/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =/#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set auto_batch_dml_update_count_verification = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = true/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =/-true;
NEW_CONNECTION;
set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
SET AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION = FALSE;
NEW_CONNECTION;
set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
   set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
			set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;



set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
set auto_batch_dml_update_count_verification = false  ;
NEW_CONNECTION;
set auto_batch_dml_update_count_verification = false		;
NEW_CONNECTION;
set auto_batch_dml_update_count_verification = false

;
NEW_CONNECTION;
set   auto_batch_dml_update_count_verification   =   false;
NEW_CONNECTION;
set	auto_batch_dml_update_count_verification	=	false;
NEW_CONNECTION;
set
auto_batch_dml_update_count_verification
=
false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =%false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =_false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =&false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =$false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =@false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =!false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =*false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =(false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =)false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =-false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =+false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =-#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =\false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =?false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =-/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =/#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set auto_batch_dml_update_count_verification = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification = false/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_batch_dml_update_count_verification =/-false;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
SET LOCAL BATCH_DML_UPDATE_COUNT = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
   set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
			set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;



set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local batch_dml_update_count = 0  ;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local batch_dml_update_count = 0		;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local batch_dml_update_count = 0

;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set   local   batch_dml_update_count   =   0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set	local	batch_dml_update_count	=	0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set
local
batch_dml_update_count
=
0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0 bar;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0%;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =%0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0_;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =_0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0&;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =&0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0$;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =$0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0@;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =@0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0!;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =!0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0*;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =*0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0(;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =(0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0);
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =)0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =-0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0+;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =+0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0-#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =-#0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =/0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0\;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =\0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0?;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =?0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0-/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =-/0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0/#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =/#0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set local batch_dml_update_count = 0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 0/-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =/-0;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
SET LOCAL BATCH_DML_UPDATE_COUNT = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
   set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
			set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;



set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local batch_dml_update_count = 100  ;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local batch_dml_update_count = 100		;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set local batch_dml_update_count = 100

;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set   local   batch_dml_update_count   =   100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set	local	batch_dml_update_count	=	100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set
local
batch_dml_update_count
=
100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100 bar;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100%;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =%100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100_;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =_100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100&;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =&100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100$;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =$100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100@;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =@100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100!;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =!100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100*;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =*100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100(;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =(100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100);
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =)100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =-100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100+;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =+100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100-#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =-#100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =/100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100\;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =\100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100?;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =?100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100-/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =-/100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100/#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =/#100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set local batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count = 100/-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set local batch_dml_update_count =/-100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
SET BATCH_DML_UPDATE_COUNT = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
   set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
			set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;



set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set batch_dml_update_count = 1  ;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set batch_dml_update_count = 1		;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set batch_dml_update_count = 1

;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set   batch_dml_update_count   =   1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set	batch_dml_update_count	=	1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set
batch_dml_update_count
=
1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1 bar;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1%;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =%1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1_;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =_1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1&;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =&1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1$;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =$1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1@;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =@1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1!;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =!1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1*;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =*1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1(;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =(1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1);
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =)1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =-1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1+;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =+1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1-#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =-#1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =/1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1\;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =\1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1?;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =?1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1-/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =-/1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1/#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =/#1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set batch_dml_update_count = 1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 1/-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =/-1;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
SET BATCH_DML_UPDATE_COUNT = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
   set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
			set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;



set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set batch_dml_update_count = 100  ;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set batch_dml_update_count = 100		;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set batch_dml_update_count = 100

;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set   batch_dml_update_count   =   100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set	batch_dml_update_count	=	100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
set
batch_dml_update_count
=
100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100 bar;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100%;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =%100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100_;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =_100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100&;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =&100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100$;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =$100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100@;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =@100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100!;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =!100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100*;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =*100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100(;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =(100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100);
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =)100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =-100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100+;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =+100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100-#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =-#100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =/100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100\;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =\100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100?;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =?100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100-/;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =-/100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100/#;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =/#100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set batch_dml_update_count = 100;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count = 100/-;
NEW_CONNECTION;
set readonly = false;
set autocommit = false;
@EXPECT EXCEPTION INVALID_ARGUMENT
set batch_dml_update_count =/-100;
NEW_CONNECTION;
show variable read_lock_mode;
NEW_CONNECTION;
SHOW VARIABLE READ_LOCK_MODE;
NEW_CONNECTION;
show variable read_lock_mode;
NEW_CONNECTION;
   show variable read_lock_mode;
NEW_CONNECTION;
			show variable read_lock_mode;
NEW_CONNECTION;



show variable read_lock_mode;
NEW_CONNECTION;
show variable read_lock_mode  ;
NEW_CONNECTION;
show variable read_lock_mode		;
NEW_CONNECTION;
show variable read_lock_mode

;
NEW_CONNECTION;
show   variable   read_lock_mode;
NEW_CONNECTION;
show	variable	read_lock_mode;
NEW_CONNECTION;
show
variable
read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable read_lock_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable read_lock_mode/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-read_lock_mode;
NEW_CONNECTION;
set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
SET READ_LOCK_MODE='OPTIMISTIC';
NEW_CONNECTION;
set read_lock_mode='optimistic';
NEW_CONNECTION;
   set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
			set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;



set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
set read_lock_mode='OPTIMISTIC'  ;
NEW_CONNECTION;
set read_lock_mode='OPTIMISTIC'		;
NEW_CONNECTION;
set read_lock_mode='OPTIMISTIC'

;
NEW_CONNECTION;
set   read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
set	read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
set
read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='OPTIMISTIC'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-read_lock_mode='OPTIMISTIC';
NEW_CONNECTION;
set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
SET READ_LOCK_MODE='PESSIMISTIC';
NEW_CONNECTION;
set read_lock_mode='pessimistic';
NEW_CONNECTION;
   set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
			set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;



set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
set read_lock_mode='PESSIMISTIC'  ;
NEW_CONNECTION;
set read_lock_mode='PESSIMISTIC'		;
NEW_CONNECTION;
set read_lock_mode='PESSIMISTIC'

;
NEW_CONNECTION;
set   read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
set	read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
set
read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='PESSIMISTIC'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-read_lock_mode='PESSIMISTIC';
NEW_CONNECTION;
set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
SET READ_LOCK_MODE='UNSPECIFIED';
NEW_CONNECTION;
set read_lock_mode='unspecified';
NEW_CONNECTION;
   set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
			set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;



set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
set read_lock_mode='UNSPECIFIED'  ;
NEW_CONNECTION;
set read_lock_mode='UNSPECIFIED'		;
NEW_CONNECTION;
set read_lock_mode='UNSPECIFIED'

;
NEW_CONNECTION;
set   read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
set	read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
set
read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set read_lock_mode='UNSPECIFIED'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-read_lock_mode='UNSPECIFIED';
NEW_CONNECTION;
show variable data_boost_enabled;
NEW_CONNECTION;
SHOW VARIABLE DATA_BOOST_ENABLED;
NEW_CONNECTION;
show variable data_boost_enabled;
NEW_CONNECTION;
   show variable data_boost_enabled;
NEW_CONNECTION;
			show variable data_boost_enabled;
NEW_CONNECTION;



show variable data_boost_enabled;
NEW_CONNECTION;
show variable data_boost_enabled  ;
NEW_CONNECTION;
show variable data_boost_enabled		;
NEW_CONNECTION;
show variable data_boost_enabled

;
NEW_CONNECTION;
show   variable   data_boost_enabled;
NEW_CONNECTION;
show	variable	data_boost_enabled;
NEW_CONNECTION;
show
variable
data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable data_boost_enabled;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable data_boost_enabled/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-data_boost_enabled;
NEW_CONNECTION;
set data_boost_enabled = true;
NEW_CONNECTION;
SET DATA_BOOST_ENABLED = TRUE;
NEW_CONNECTION;
set data_boost_enabled = true;
NEW_CONNECTION;
   set data_boost_enabled = true;
NEW_CONNECTION;
			set data_boost_enabled = true;
NEW_CONNECTION;



set data_boost_enabled = true;
NEW_CONNECTION;
set data_boost_enabled = true  ;
NEW_CONNECTION;
set data_boost_enabled = true		;
NEW_CONNECTION;
set data_boost_enabled = true

;
NEW_CONNECTION;
set   data_boost_enabled   =   true;
NEW_CONNECTION;
set	data_boost_enabled	=	true;
NEW_CONNECTION;
set
data_boost_enabled
=
true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =%true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =_true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =&true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =$true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =@true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =!true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =*true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =(true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =)true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =-true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =+true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =-#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =\true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =?true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =-/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =/#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set data_boost_enabled = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = true/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =/-true;
NEW_CONNECTION;
set data_boost_enabled = false;
NEW_CONNECTION;
SET DATA_BOOST_ENABLED = FALSE;
NEW_CONNECTION;
set data_boost_enabled = false;
NEW_CONNECTION;
   set data_boost_enabled = false;
NEW_CONNECTION;
			set data_boost_enabled = false;
NEW_CONNECTION;



set data_boost_enabled = false;
NEW_CONNECTION;
set data_boost_enabled = false  ;
NEW_CONNECTION;
set data_boost_enabled = false		;
NEW_CONNECTION;
set data_boost_enabled = false

;
NEW_CONNECTION;
set   data_boost_enabled   =   false;
NEW_CONNECTION;
set	data_boost_enabled	=	false;
NEW_CONNECTION;
set
data_boost_enabled
=
false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =%false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =_false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =&false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =$false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =@false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =!false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =*false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =(false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =)false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =-false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =+false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =-#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =\false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =?false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =-/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =/#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set data_boost_enabled = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled = false/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set data_boost_enabled =/-false;
NEW_CONNECTION;
show variable auto_partition_mode;
NEW_CONNECTION;
SHOW VARIABLE AUTO_PARTITION_MODE;
NEW_CONNECTION;
show variable auto_partition_mode;
NEW_CONNECTION;
   show variable auto_partition_mode;
NEW_CONNECTION;
			show variable auto_partition_mode;
NEW_CONNECTION;



show variable auto_partition_mode;
NEW_CONNECTION;
show variable auto_partition_mode  ;
NEW_CONNECTION;
show variable auto_partition_mode		;
NEW_CONNECTION;
show variable auto_partition_mode

;
NEW_CONNECTION;
show   variable   auto_partition_mode;
NEW_CONNECTION;
show	variable	auto_partition_mode;
NEW_CONNECTION;
show
variable
auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable auto_partition_mode;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable auto_partition_mode/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-auto_partition_mode;
NEW_CONNECTION;
set auto_partition_mode = true;
NEW_CONNECTION;
SET AUTO_PARTITION_MODE = TRUE;
NEW_CONNECTION;
set auto_partition_mode = true;
NEW_CONNECTION;
   set auto_partition_mode = true;
NEW_CONNECTION;
			set auto_partition_mode = true;
NEW_CONNECTION;



set auto_partition_mode = true;
NEW_CONNECTION;
set auto_partition_mode = true  ;
NEW_CONNECTION;
set auto_partition_mode = true		;
NEW_CONNECTION;
set auto_partition_mode = true

;
NEW_CONNECTION;
set   auto_partition_mode   =   true;
NEW_CONNECTION;
set	auto_partition_mode	=	true;
NEW_CONNECTION;
set
auto_partition_mode
=
true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =%true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =_true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =&true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =$true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =@true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =!true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =*true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =(true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =)true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =-true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =+true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =-#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =\true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =?true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =-/true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =/#true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set auto_partition_mode = true;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = true/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =/-true;
NEW_CONNECTION;
set auto_partition_mode = false;
NEW_CONNECTION;
SET AUTO_PARTITION_MODE = FALSE;
NEW_CONNECTION;
set auto_partition_mode = false;
NEW_CONNECTION;
   set auto_partition_mode = false;
NEW_CONNECTION;
			set auto_partition_mode = false;
NEW_CONNECTION;



set auto_partition_mode = false;
NEW_CONNECTION;
set auto_partition_mode = false  ;
NEW_CONNECTION;
set auto_partition_mode = false		;
NEW_CONNECTION;
set auto_partition_mode = false

;
NEW_CONNECTION;
set   auto_partition_mode   =   false;
NEW_CONNECTION;
set	auto_partition_mode	=	false;
NEW_CONNECTION;
set
auto_partition_mode
=
false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =%false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =_false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =&false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =$false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =@false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =!false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =*false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =(false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =)false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =-false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =+false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =-#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =\false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =?false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =-/false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =/#false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set auto_partition_mode = false;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode = false/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set auto_partition_mode =/-false;
NEW_CONNECTION;
show variable max_partitions;
NEW_CONNECTION;
SHOW VARIABLE MAX_PARTITIONS;
NEW_CONNECTION;
show variable max_partitions;
NEW_CONNECTION;
   show variable max_partitions;
NEW_CONNECTION;
			show variable max_partitions;
NEW_CONNECTION;



show variable max_partitions;
NEW_CONNECTION;
show variable max_partitions  ;
NEW_CONNECTION;
show variable max_partitions		;
NEW_CONNECTION;
show variable max_partitions

;
NEW_CONNECTION;
show   variable   max_partitions;
NEW_CONNECTION;
show	variable	max_partitions;
NEW_CONNECTION;
show
variable
max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable max_partitions;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitions/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-max_partitions;
NEW_CONNECTION;
set max_partitions = 0;
NEW_CONNECTION;
SET MAX_PARTITIONS = 0;
NEW_CONNECTION;
set max_partitions = 0;
NEW_CONNECTION;
   set max_partitions = 0;
NEW_CONNECTION;
			set max_partitions = 0;
NEW_CONNECTION;



set max_partitions = 0;
NEW_CONNECTION;
set max_partitions = 0  ;
NEW_CONNECTION;
set max_partitions = 0		;
NEW_CONNECTION;
set max_partitions = 0

;
NEW_CONNECTION;
set   max_partitions   =   0;
NEW_CONNECTION;
set	max_partitions	=	0;
NEW_CONNECTION;
set
max_partitions
=
0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0 bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =%0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =_0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =&0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =$0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =@0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =!0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =*0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =(0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =)0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =-0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =+0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =-#0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =/0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =\0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =?0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =-/0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =/#0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_partitions = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 0/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =/-0;
NEW_CONNECTION;
set max_partitions = 10;
NEW_CONNECTION;
SET MAX_PARTITIONS = 10;
NEW_CONNECTION;
set max_partitions = 10;
NEW_CONNECTION;
   set max_partitions = 10;
NEW_CONNECTION;
			set max_partitions = 10;
NEW_CONNECTION;



set max_partitions = 10;
NEW_CONNECTION;
set max_partitions = 10  ;
NEW_CONNECTION;
set max_partitions = 10		;
NEW_CONNECTION;
set max_partitions = 10

;
NEW_CONNECTION;
set   max_partitions   =   10;
NEW_CONNECTION;
set	max_partitions	=	10;
NEW_CONNECTION;
set
max_partitions
=
10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10 bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =%10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =_10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =&10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =$10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =@10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =!10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =*10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =(10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =)10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =-10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =+10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =-#10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =/10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =\10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =?10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =-/10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =/#10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_partitions = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions = 10/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitions =/-10;
NEW_CONNECTION;
show variable max_partitioned_parallelism;
NEW_CONNECTION;
SHOW VARIABLE MAX_PARTITIONED_PARALLELISM;
NEW_CONNECTION;
show variable max_partitioned_parallelism;
NEW_CONNECTION;
   show variable max_partitioned_parallelism;
NEW_CONNECTION;
			show variable max_partitioned_parallelism;
NEW_CONNECTION;



show variable max_partitioned_parallelism;
NEW_CONNECTION;
show variable max_partitioned_parallelism  ;
NEW_CONNECTION;
show variable max_partitioned_parallelism		;
NEW_CONNECTION;
show variable max_partitioned_parallelism

;
NEW_CONNECTION;
show   variable   max_partitioned_parallelism;
NEW_CONNECTION;
show	variable	max_partitioned_parallelism;
NEW_CONNECTION;
show
variable
max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable max_partitioned_parallelism;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable max_partitioned_parallelism/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-max_partitioned_parallelism;
NEW_CONNECTION;
set max_partitioned_parallelism = 0;
NEW_CONNECTION;
SET MAX_PARTITIONED_PARALLELISM = 0;
NEW_CONNECTION;
set max_partitioned_parallelism = 0;
NEW_CONNECTION;
   set max_partitioned_parallelism = 0;
NEW_CONNECTION;
			set max_partitioned_parallelism = 0;
NEW_CONNECTION;



set max_partitioned_parallelism = 0;
NEW_CONNECTION;
set max_partitioned_parallelism = 0  ;
NEW_CONNECTION;
set max_partitioned_parallelism = 0		;
NEW_CONNECTION;
set max_partitioned_parallelism = 0

;
NEW_CONNECTION;
set   max_partitioned_parallelism   =   0;
NEW_CONNECTION;
set	max_partitioned_parallelism	=	0;
NEW_CONNECTION;
set
max_partitioned_parallelism
=
0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0 bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =%0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =_0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =&0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =$0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =@0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =!0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =*0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =(0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =)0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =-0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =+0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =-#0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =/0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =\0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =?0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =-/0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =/#0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_partitioned_parallelism = 0;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 0/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =/-0;
NEW_CONNECTION;
set max_partitioned_parallelism = 10;
NEW_CONNECTION;
SET MAX_PARTITIONED_PARALLELISM = 10;
NEW_CONNECTION;
set max_partitioned_parallelism = 10;
NEW_CONNECTION;
   set max_partitioned_parallelism = 10;
NEW_CONNECTION;
			set max_partitioned_parallelism = 10;
NEW_CONNECTION;



set max_partitioned_parallelism = 10;
NEW_CONNECTION;
set max_partitioned_parallelism = 10  ;
NEW_CONNECTION;
set max_partitioned_parallelism = 10		;
NEW_CONNECTION;
set max_partitioned_parallelism = 10

;
NEW_CONNECTION;
set   max_partitioned_parallelism   =   10;
NEW_CONNECTION;
set	max_partitioned_parallelism	=	10;
NEW_CONNECTION;
set
max_partitioned_parallelism
=
10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10 bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =%10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =_10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =&10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =$10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =@10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =!10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =*10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =(10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10);
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =)10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =-10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =+10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =-#10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =/10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =\10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =?10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =-/10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =/#10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set max_partitioned_parallelism = 10;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism = 10/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set max_partitioned_parallelism =/-10;
NEW_CONNECTION;
set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
SET PROTO_DESCRIPTORS='PROTODESCRIPTORSBASE64';
NEW_CONNECTION;
set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
   set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
			set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;



set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
set proto_descriptors='protodescriptorsbase64'  ;
NEW_CONNECTION;
set proto_descriptors='protodescriptorsbase64'		;
NEW_CONNECTION;
set proto_descriptors='protodescriptorsbase64'

;
NEW_CONNECTION;
set   proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
set	proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
set
proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors='protodescriptorsbase64'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-proto_descriptors='protodescriptorsbase64';
NEW_CONNECTION;
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
SET PROTO_DESCRIPTORS_FILE_PATH='SRC/TEST/RESOURCES/COM/GOOGLE/CLOUD/SPANNER/DESCRIPTORS.PB';
NEW_CONNECTION;
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
   set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
			set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;



set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'  ;
NEW_CONNECTION;
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'		;
NEW_CONNECTION;
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'

;
NEW_CONNECTION;
set   proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
set	proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
set
proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb' bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'%;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set%proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'_;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set_proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'&;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set&proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'$;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set$proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'@;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set@proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'!;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set!proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'*;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set*proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'(;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set(proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb');
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set)proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'+;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set+proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'-#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-#proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'\;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set\proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'?;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set?proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'-/;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set-/proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'/#;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/#proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb'/-;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
set/-proto_descriptors_file_path='src/test/resources/com/google/cloud/spanner/descriptors.pb';
NEW_CONNECTION;
show variable proto_descriptors;
NEW_CONNECTION;
SHOW VARIABLE PROTO_DESCRIPTORS;
NEW_CONNECTION;
show variable proto_descriptors;
NEW_CONNECTION;
   show variable proto_descriptors;
NEW_CONNECTION;
			show variable proto_descriptors;
NEW_CONNECTION;



show variable proto_descriptors;
NEW_CONNECTION;
show variable proto_descriptors  ;
NEW_CONNECTION;
show variable proto_descriptors		;
NEW_CONNECTION;
show variable proto_descriptors

;
NEW_CONNECTION;
show   variable   proto_descriptors;
NEW_CONNECTION;
show	variable	proto_descriptors;
NEW_CONNECTION;
show
variable
proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable proto_descriptors;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-proto_descriptors;
NEW_CONNECTION;
show variable proto_descriptors_file_path;
NEW_CONNECTION;
SHOW VARIABLE PROTO_DESCRIPTORS_FILE_PATH;
NEW_CONNECTION;
show variable proto_descriptors_file_path;
NEW_CONNECTION;
   show variable proto_descriptors_file_path;
NEW_CONNECTION;
			show variable proto_descriptors_file_path;
NEW_CONNECTION;



show variable proto_descriptors_file_path;
NEW_CONNECTION;
show variable proto_descriptors_file_path  ;
NEW_CONNECTION;
show variable proto_descriptors_file_path		;
NEW_CONNECTION;
show variable proto_descriptors_file_path

;
NEW_CONNECTION;
show   variable   proto_descriptors_file_path;
NEW_CONNECTION;
show	variable	proto_descriptors_file_path;
NEW_CONNECTION;
show
variable
proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
foo show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path bar;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
%show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path%;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable%proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
_show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path_;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable_proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
&show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path&;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable&proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
$show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path$;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable$proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
@show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path@;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable@proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
!show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path!;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable!proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
*show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path*;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable*proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
(show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path(;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable(proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
)show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path);
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable)proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
+show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path+;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable+proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-#show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path-#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-#proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
\show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path\;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable\proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
?show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path?;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable?proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
-/show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path-/;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable-/proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/#show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path/#;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/#proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION INVALID_ARGUMENT
/-show variable proto_descriptors_file_path;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable proto_descriptors_file_path/-;
NEW_CONNECTION;
@EXPECT EXCEPTION UNIMPLEMENTED
show variable/-proto_descriptors_file_path;
