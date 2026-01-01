# Easy Steps to Run This Project in VS Code

## Step 1: Install Java JDK
- Download and install Java JDK (version 8 or higher) from: https://www.oracle.com/java/technologies/downloads/
- Or use OpenJDK: https://adoptium.net/
- Verify installation by opening terminal and typing: `java -version`

## Step 2: Install VS Code Java Extensions
1. Open VS Code
2. Click the Extensions icon (or press `Ctrl+Shift+X`)
3. Search for and install these extensions:
   - **Extension Pack for Java** (by Microsoft) - This includes everything you need

## Step 3: Open the Project
1. In VS Code, go to **File → Open Folder**
2. Navigate to: `D:\3rd SEM\JAVA\javagroup-main`
3. Click "Select Folder"

## Step 4: Run the Project
**Option A: Using VS Code (Easiest)**
1. Open the file: `src/com/hospital/main/Main.java`
2. Click the **▶ Run** button that appears above the `main` method
3. Or press `F5` to run

**Option B: Using Terminal**
1. Open terminal in VS Code (`Ctrl+`` ` or Terminal → New Terminal)
2. Navigate to the project root:
   ```
   cd "D:\3rd SEM\JAVA\javagroup-main"
   ```
3. Compile:
   ```
   javac -d bin -sourcepath src src/com/hospital/main/Main.java
   ```
4. Run:
   ```
   java -cp bin com.hospital.main.Main
   ```

## That's it! 🎉
The program should run and display the hospital details.

## Troubleshooting
- If you see "Java not found": Make sure Java JDK is installed and added to PATH
- If extensions don't work: Restart VS Code after installing extensions
- If compilation errors: Make sure all Java files are in the correct package structure

