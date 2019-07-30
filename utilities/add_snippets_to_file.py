# Copyright 2016 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import argparse
import logging
import os
import plyj.model as ast
import plyj.parser as plyj
import re

NEWLINE_PATTERN = re.compile(r'\n')
LOGGER = logging.getLogger(__name__)

class Parameter(object):

    def __init__(self, name, signature_type, complete_type):
        self.name = name
        self.signature_type = signature_type
        self.complete_type = complete_type

class Method(object):

    def __init__(self, name, parameters, signature, regex):
        self.name = name
        self.parameters = parameters
        self.signature = signature
        self.regex = regex

    @classmethod
    def parse_type(csl, ast_type, is_vararg):
        parameter_type = ''
        parameter_complete_type = ''
        if isinstance(ast_type, ast.Wildcard):
             parameter_type = '?'
             parameter_complete_type = '?'
        elif isinstance(ast_type, ast.Type):
            if isinstance(ast_type.name, ast.Name):
                parameter_type = ast_type.name.value
                parameter_complete_type = ast_type.name.value
            else:
                parameter_type = ast_type.name
                parameter_complete_type = ast_type.name
            if hasattr(ast_type, 'type_arguments') and ast_type.type_arguments:
                parameter_complete_type += '<{}>'.format(
                    ', '.join(Method.parse_type(astSubType, False)[1]
                        for astSubType in ast_type.type_arguments))
            dimensions = ''.join('[]' * ast_type.dimensions)
            parameter_type += dimensions
            parameter_complete_type += dimensions
        else:
            parameter_type = ast_type
            parameter_complete_type = ast_type
        if is_vararg:
            parameter_type += '...'
            parameter_complete_type += '...'
        return (parameter_type, parameter_complete_type)

    @classmethod
    def parse_arguments(csl, ast_method_declaration):
        parameters = []
        for ast_parameter in ast_method_declaration.parameters:
            (parameter_signature_type, parameter_complete_type) = Method.parse_type(
                ast_parameter.type,
                hasattr(ast_parameter, 'vararg') and ast_parameter.vararg)
            parameter = Parameter(
                ast_parameter.variable.name,
                parameter_signature_type,
                parameter_complete_type)
            parameters.append(parameter)
        return parameters

    @classmethod
    def parse_methods(cls, data, class_name):
        parser = plyj.Parser()
        tree = parser.parse_string(data)
        LOGGER.info('Parsing methods for class %s.', class_name)
        methods = []
        for ast_type_declaration in tree.type_declarations:
            if ast_type_declaration.name == class_name:
                for ast_declaration in ast_type_declaration.body:
                    if isinstance(ast_declaration, ast.MethodDeclaration):
                        method_name = ast_declaration.name
                        parameters = Method.parse_arguments(ast_declaration)
                        signature = '{}({})'.format(
                            method_name, ', '.join(
                                [parameter.signature_type for parameter in parameters]))
                        regex = '{}\(\s*{}\)'.format(re.escape(method_name),
                            ',\s+'.join(['(final\s+)?{}\s+{}'.format(
                                re.escape(parameter.complete_type), re.escape(parameter.name))
                            for parameter in parameters]))
                        method = cls(method_name, parameters, signature, regex)
                        methods.append(method)
        return methods

class Snippet(object):

    def __init__(self, name, target, caption, variables, code, signature, parameters):
        self.name = name
        self.target = target
        self.caption = caption
        self.variables = variables
        self.code = code
        self.signature = signature
        self.parameters = parameters

    def to_javadoc(snippet):
        """
        Returns a list of string representing the snippet in javadoc format.
        """
        javadoc = []
        caption = snippet.caption
        head, tail = caption[0], caption[1:]
        parameters = snippet.parameters
        variables = snippet.variables
        if len(parameters) != len(variables):
            raise ValueError('Parameters do not match variables for method {}'.format(
                snippet.signature))
        javadoc.append('   *\n')
        javadoc.append('   * <p>' + head + '\n')
        for line in tail:
            javadoc.append('   * ' + line + '\n')
        javadoc.append('   * <pre> {@code\n')
        for parameter, value in zip(parameters, variables):
            javadoc.append('   * {} {} = {};\n'.format(
                parameter.complete_type,
                parameter.name,
                value))
        first_code_line = snippet.code[0]
        indent = len(first_code_line) - len(first_code_line.lstrip())
        for codeLine in snippet.code:
            javadoc.append('   * ' + codeLine[indent:] + '\n')
        javadoc.append('   * }</pre>\n')
        return javadoc

    @classmethod
    def parse_caption(cls, index, lines):
        caption = []
        while index < len(lines):
            stripped_line = lines[index].strip()
            if stripped_line.startswith('*/'):
                return (index, caption)
            caption.append(stripped_line.strip('*').lstrip())
            index += 1
        raise ValueError('Javadoc comment is never closed')

    @classmethod
    def parse_code(cls, index, lines, name):
        code = []
        while index < len(lines):
            line = lines[index].rstrip()
            if line.lstrip().startswith('// [END ' + name + ']'):
                return (index, code)
            code.append(line)
            index += 1
        raise ValueError('Snippet {} is missing an END tag'.format(name))

    @classmethod
    def parse_snippet_javadoc(csl, index, lines):
        javadoc = []
        while index >= 0:
            line = lines[index]
            index -= 1
            javadoc.append(line)
            stripped_line = line.lstrip()
            if not stripped_line.startswith('*'):
                raise ValueError('Could not parse javadoc snippet:\n{}'.format(javadoc))
            if stripped_line.startswith('* <p>'):
                if index >= 0:
                    next_line = lines[index].strip()
                    if next_line == '*':
                        javadoc.append(next_line)
                return javadoc
        raise ValueError('Could not parse javadoc snippet:\n{}'.format(javadoc))

    @classmethod
    def remove_snippets(csl, signature, lines, line_numbers):
        """Removes javadoc snippets for a method with the provided signature.

        This method removes the lines that correspond to javadoc snippets, returns the updated
        lines and updates the line_numbers data structure in the process.

        A snippet's javadoc should have the following format (as generated by to_javadoc()):
        * <p>...
        * ...
        * ...
        * ...}</pre>
        """
        index = line_numbers.get(signature)
        LOGGER.info('Removing snippets for method %s', signature)
        while index >= 0:
            line = lines[index].lstrip()
            if line.startswith('/**'):
                return lines
            if line.rstrip().endswith('}</pre>'):
                javadoc = Snippet.parse_snippet_javadoc(index, lines);
                new_index = index - len(javadoc)
                line_numbers.update(index, - len(javadoc))
                lines = lines[:new_index + 1] + lines[index + 1:]
                index = new_index
            else:
                index -= 1
        raise ValueError('Could not parse javadoc snippets for method {}'.format(signature))

    @classmethod
    def parse_snippets(cls, snippets_filename):
        """Parses a file looking for code snippets. Returns a list of Snippet objects.

        Snippets should have the following format:
        /**
         * Snippet caption.
         */
        // [TARGET method(Type1, Type2)]
        // [VARIABLE "stringValue"]
        // [VARIABLE 42]
        public void snippetMethod(String arg1, int arg2) {
          // [START snippetMethod]
          here goes snippet code
          // [END snippetMethod]
        }
        """
        snippets_name = os.path.splitext(os.path.basename(snippets_filename))[0]
        LOGGER.info('Parsing snippets from class %s.', snippets_name)
        snippets = []
        with open(snippets_filename, 'r') as snippets_file:
            snippets_string = snippets_file.read()
            methods = Method.parse_methods(snippets_string, snippets_name)
            target = None
            caption = []
            variables = []
            code = []
            snippets_lines = snippets_string.splitlines(True)
            index = 0
            method_index = 0
            while index < len(snippets_lines):
                stripped_line = snippets_lines[index].strip()
                index += 1
                if stripped_line.startswith('public class {} {{'.format(snippets_name)):
                    break
            while index < len(snippets_lines):
                stripped_line = snippets_lines[index].strip()
                index += 1
                if stripped_line.startswith('/**'):
                    target = None
                    caption = ''
                    variables = []
                    code = ''
                    (index, caption) = Snippet.parse_caption(index, snippets_lines)
                    continue
                if stripped_line.startswith('// [TARGET'):
                    target = stripped_line.replace('// [TARGET ', '').rstrip(']')
                    continue
                if stripped_line.startswith('// [START '):
                    snippet_name = stripped_line.replace('// [START ', '').rstrip(']')
                    (index, code) = Snippet.parse_code(index, snippets_lines, snippet_name)
                    snippet = cls(
                        snippet_name,
                        target,
                        caption,
                        variables,
                        code,
                        methods[method_index].signature,
                        methods[method_index].parameters)
                    snippets.append(snippet)
                    method_index += 1
                    continue
                if stripped_line.startswith('// [VARIABLE'):
                    variables.append(stripped_line.replace('// [VARIABLE ', '').rstrip(']'))
                    continue
            return snippets

    @classmethod
    def write_snippets(cls, snippets, filename):
        """
        Writes the collection of the Snippets to the provided file.
        """
        with open (filename, 'r+') as java_file:
            string = java_file.read()
            lines = string.splitlines(True)
            class_name = os.path.splitext(os.path.basename(filename))[0]
            methods = Method.parse_methods(string, class_name)
            line_numbers = LineNumbers(string, methods)
            for method in methods:
                lines = Snippet.remove_snippets(method.signature, lines, line_numbers)
            for snippet in snippets:
                target = snippet.target
                LOGGER.info('Building snippet for method %s#%s.', class_name, target)
                target_line = line_numbers.get(target)
                index = target_line - 2
                javadoc = snippet.to_javadoc()
                while index >= 0:
                    stripped_line = lines[index].strip()
                    if (stripped_line.startswith('/**')):
                        break
                    index -= 1
                previous_line = ''
                while index <= len(lines):
                    stripped_line = lines[index].strip()
                    if stripped_line == '*/' or stripped_line.startswith('* @'):
                        if previous_line.strip() != '*':
                            indent = len(previous_line) - len(previous_line.lstrip())
                            javadoc = javadoc + [previous_line[:indent] + '*\n']
                        else:
                            index -= 1
                        break
                    previous_line = lines[index]
                    index += 1
                lines[index:index] = javadoc
                line_numbers.update(target_line, len(javadoc))
            java_file.seek(0)
            java_file.writelines(lines)
            java_file.truncate()

class LineNumbers(object):

    def __init__(self, data, methods):
        self.line_numbers = {}
        for method in methods:
            pattern = re.compile('\s+' + method.regex)
            for match in pattern.finditer(data):
                line_number = len(NEWLINE_PATTERN.findall(data[:match.start()])) + 1
                signature = method.signature
                if signature in self.line_numbers:
                    LOGGER.warning('Method %s duplicate at line %d.', signature, line_number)
                    continue
                LOGGER.info('Method %s found at line %d.', signature, line_number)
                self.line_numbers[signature] = line_number

    def get(self, signature):
        """
        Returns the line number for the provided method.
        """
        return self.line_numbers[signature]

    def update(self, at, count):
        """
        Inserts (if count is positive) or removes (if count is negative) count lines at the
        provided position. Line numbers are updated accordingly.
        """
        updated_line_numbers = {}
        for target in self.line_numbers:
            target_line = self.line_numbers[target]
            if (target_line >= at):
                target_line += count
            updated_line_numbers[target] = target_line
        self.line_numbers = updated_line_numbers

def main():
    parser = argparse.ArgumentParser(description='Add snippets to Javadoc.')
    parser.add_argument('snippets_path', help='Path to the Java source file for the snippets.')
    parser.add_argument('class_path', help='Path to the Java source file where to add snippets.')
    args = parser.parse_args()

    snippets_file = args.snippets_path
    class_file = args.class_path

    snippets = Snippet.parse_snippets(snippets_file)
    Snippet.write_snippets(snippets, class_file)

if __name__ == '__main__':
    main()
