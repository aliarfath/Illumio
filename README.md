# Illumio
Technical Assessment

Program to read a file and finds matches against a predefined set of words.

## Requirements 

- Input file is a plain text (ascii) file, every record separated by a new line. 
- English words only 
- File size can be up to 20 MB 
- Predefined words are defined in a text file, every word separated by a newline.
- Predefined words file doesn’t contain duplicates 
- Maximum length of the word can be upto 256 
- Matches should be case-insensitive 
- The match should be word to word match, no substring matches. 

Sample input

- Line 1: Detecting first names is tricky to do even with AI. 
- Line 2: how do you say a street name is not a first name?  

Sample predefined words

- Name 
- Detect 
- AI 

Output

- Predefined word   |    Match count 
    - Name              |             2 
    - AI                |             1 

### Assumption

- I'm only showing the words in the output which are present in input.txt.
- If a word appears multiple times in a single line that's also counted.
- Word size check is added to skip anything above 256.
- Empty input or predefined word files are ignored and empty response is showed.

## How to run

- WordMatchCounterApp has a main method. You can initialize the predefinedword through constructor by passing the predefined word file.
    -  ` WordMatchCounterApp wordMatchCounterApp = new WordMatchCounterApp("src/main/resources/PreDefinedWords");`
    -    `wordMatchCounterApp.countWordMatches("src/main/resources/input.txt");`
    -    `wordMatchCounterApp.printWordCounts(); `

- I've added unit tests for different cases, those also can be used and more tests or cases can be added.
    - `WordMatchCounterAppTest`
    