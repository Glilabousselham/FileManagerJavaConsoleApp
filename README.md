# FileManager Java Console App

## Overview
The **FileManager** is a Java-based console application that provides basic file and directory management functionalities. It allows users to interact with the file system through simple commands, making it an intuitive tool for navigating and managing directories.

## Features
The application supports the following functionalities:

### 1. **ls**
Lists the files and directories in the current working directory.
- **Usage:**
  ```
  ls
  ```

### 2. **pwd**
Prints the absolute path of the current working directory.
- **Usage:**
  ```
  pwd
  ```

### 3. **cd**
Changes the current directory. This command allows only one step at a time.
- Navigate into a directory:
  ```
  cd <directory_name>
  ```
  Example:
  ```
  cd test
  ```
- Navigate to the parent directory:
  ```
  cd ..
  ```

### 4. **mkdir**
Creates a new directory in the current working directory.
- **Usage:**
  ```
  mkdir <directory_name>
  ```
  Example:
  ```
  mkdir test
  ```

## How to Use
1. Clone the repository:
   ```
   git clone https://github.com/your-username/FileManager.git
   ```
2. Navigate to the project directory:
   ```
   cd FileManager
   ```
3. Compile the Java program using:
   ```
   javac FileManager.java
   ```
4. Run the application:
   ```
   java FileManager
   ```
5. Use the supported commands to interact with the file system.

## Example Session
```plaintext
> pwd
/home/user

> ls
test
file.txt

> cd test

> pwd
/home/user/test

> mkdir new_folder

> ls
new_folder

> cd ..

> pwd
/home/user
```

## Requirements
- Java Development Kit (JDK) 8 or later.

## Limitations
- The `cd` command supports only single-step navigation (into a directory or to the parent directory).
- Limited to basic file and directory operations.

## Future Enhancements
- Support for recursive navigation (e.g., `cd dir1/dir2`).
- Additional commands for file operations, such as copy, move, and delete.
- Enhanced error handling and user feedback for invalid commands or paths.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

