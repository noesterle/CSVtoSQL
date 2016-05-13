This program reads in a CSV file and creates an sqlite3 script.

This assumes that sqlite3 and java is installed and configured. 

To use:
Download *src* folder.
Put the csv file along side the *src* folder.
Open command prompt/Terminal and navigate into *src*.
Execute the command "javac \*.java". This will compile the code.
Then run "java main". This runs the program.
Open up the folder that src is in, and there should be a new file called *sql.txt*. This is the file containing the sqlite3 statments.
Now, type "sqlite3" in your command prompt/Terminal to open a new shell.
Type ".read sql.txt" to get that data in your current prompt.
