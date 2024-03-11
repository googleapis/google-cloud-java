"""
Helper script to generate arguments for new-client.py from environment variables
"""
import sys
import os

required_args = [
  'API_SHORTNAME',
  'NAME_PRETTY',
  'API_DESCRIPTION',
  'PROTO_PATH',
  'PRODUCT_DOCS',
]

optional_args = [
  'REST_DOCS',
  'RPC_DOCS',
  'LIBRARY_NAME',
  'DISTRIBUTION_NAME',
]

def main() -> None:
  result = ''
  queries = [(required_args, True), (optional_args, False)]
  for (args, is_required) in queries:
    for arg in args:
      value = os.getenv(arg)
      result += __to_python_arg(arg, value, is_required)

  print(result)

def __to_python_arg(arg: str, value: str, is_required: bool) -> str:
  if value is None:
    if is_required:
      sys.exit(f'required env var {arg} is not set')
    return ""

  return f"--{arg.lower().replace('-','_')} \"{value}\" "



if __name__ == "__main__":
  main()
