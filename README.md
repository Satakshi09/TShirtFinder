### TShirtSearch
TShirtSearch is a Java program that allows users to search for T-shirts across multiple CSV files containing data for different companies (Nike, Puma, Adidas). The program takes user inputs for color, size, gender, and output preference, then searches the CSV files for matching T-shirts and displays the results sorted according to the user's preference.


## Prerequisites
Java 8 or higher installed
Maven 3.x installed
Ant installed (for building the JAR)

## Project Structure
<img width="323" alt="image" src="https://github.com/Satakshi09/TShirt-Finder/assets/60273824/6521cbdd-fa7f-4a32-bc56-3d72576ae573">

## Running the Program

# Clone the repository:

git clone https://github.com/yourusername/TShirtFinder.git
cd TShirtFinder

# Build the project using Maven:
mvn clean install
Run the program:

java -jar target/TShirtSearch-1.0-SNAPSHOT.jar <color> <size> <gender> <output_preference>
Replace <color>, <size>, <gender>, and <output_preference> with your desired inputs.


## Configuration
Additional CSV files for other companies can be added to the src/main/resources/csv directory.
The program checks for new CSV files in the same directory after a configurable time using a separate thread.


