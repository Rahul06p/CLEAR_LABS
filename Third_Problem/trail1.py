#import json package
import json
#gather Language Input from user:
Lang = input("Enter Language :")
print('Entered Language is :'+Lang)
#gather Filename Input from user:
userFileName = input("Enter FileName:")
print('Entered FileName is :'+userFileName)
#open file and load json file
with open(userFileName,'r') as file:
  data = json.load(file)
#print json file contents
print(data)
#close the file
file.close()
#open file in read mode and print the contents
InputFile = open(userFileName,'r')
if InputFile.mode == 'r':
  contents = InputFile.read()
  print(contents)
#from googletrans import translator package and print the result
from googletrans import Translator
file_translate = Translator()
result = Translator().translate(contents, dest=Lang)
print(result.text)
#create a json output file in write mode to store the translated  contents from user file
with open('output.json', 'w') as OutputFile:
  json.dump(result.text, OutputFile, ensure_ascii=False)
#close the file references.
InputFile.close()
OutputFile.close()
#inform user that translated json file is created.
print('output.json file is created at same path')