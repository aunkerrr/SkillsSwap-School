# SkillsSwap-School

SkillSwap School is a prototype platform for skills exchange between students. Users can offer their expertise and request support in subjects where they face difficulties, creating a virtuous circle of peer learning.

## Data Models

The application relies on several CSV files to store data. Here is the structure of these files:

*   **students.csv**: Contains student information including ID, name, grade/class, email, and average rating.
*   **skills.csv**: Lists available skills with their ID, name, and category.
*   **offers.csv / requests.csv**: Links students with skills, specifying proficiency levels and notes.
*   **exchanges.csv**: Records transaction data and the status of exchanges.
*   **reviews.csv**: Stores the history of reviews and feedback.

Used composition mechanism to connect different files
and provide serious efficiency improvement and unite student
object as one object and make it accessible using structure like
"String authorName = myReview.getReviewer().getName();"
so the models can be treated as unite structure and migration 
processes or name changes (example) or smth like that will pass smoothly and don't 
destroy structure overall.

https://mailharshkhatri.medium.com/understanding-composition-in-object-oriented-programming-a-beginners-guide-e2f122f84b25
https://stackoverflow.com/questions/3441090/what-is-composition-as-it-relates-to-object-oriented-design

My personal opinion is that this mechanism should be
used over Inheritance (sometimes), which in some cases is going to be more annoying
to use also as implement (Inheritance mechanisms).

Added IdGeneratorImpl and it's constructor private just to be sure that nobody calls it
generates so random ids that's almost impossible that they will be same.

Added StudentService for functionality realization (such as student adding) and separation it from main to make main as clear as
it possible.

SkillSwapState serves as a RAM storage for our project which occupies pretty small memory
and has pretty great researching speed cause its realization based on HashMap.

InMemoryStorage is a method for further functionality such as csv saving and loading
which later could be possibly transformed to work with database.

Why String for menus: Using scanner.nextLine() avoids the classic "Scanner bug"
(where nextInt() leaves a hidden \n in the buffer, skipping the next input).
It also prevents the application from immediately crashing with an
InputMismatchException if the user accidentally types a letter.

Elegant Error Handling: By passing the String directly into the switch
statement, any invalid input naturally falls into the default case.
This handles bad inputs gracefully without needing a messy try-catch block.

Solving the int problem: When an integer is strictly required
(like the class number), the solution is to read the input as a String first
and manually convert it using Integer.parseInt().
This specific conversion is then wrapped in a try-catch (NumberFormatException)
to catch typing mistakes safely without breaking the input flow.

Livened up the interface: Created the main App.java loop with a
text menu (TUI) that is resistant to input errors.

Implemented industry standards: Connected to Google's libphonenumber
library for smart validation and formatting of phones (linked to the IT region).

We protected the data: We wrote EmailValidator using regular expressions
and added "safe" number input with NumberFormatException handling.

We've improved the architecture: We've separated the code into
interfaces and implementations (Impl), following SOLID principles. Validation logic is now separated from menu logic.

### Fix CsvDataLoader and Logger implementation
* **Fixed logger syntax:** Replaced invalid `logger.("...")` calls with `logger.error(...)` in catch blocks.
* **Implemented Factory Pattern:** Properly initialized the SLF4J logger using `LoggerFactory.getLogger()`.
* **Improved logging performance:** Replaced string concatenation (`+`) with SLF4J parameterized logging (`{}`).
* **Updated Mock Data:** Updated `students.csv` with strictly valid data (real 128-bit UUIDs and correct Italian phone numbers) to comply with system validators.

### Refactored UI and Business Logic Separation (Single Responsibility Principle)
* **What we did**: Moved console output (`System.out.println`) from `StudentServiceImpl` into a dedicated UI component (`ListAllStudentMenu`). The `StudentService` now simply returns data collections (`getAllStudent()`).
* **Why it's good**: This adheres to the **Single Responsibility Principle**. The service layer is no longer tightly coupled to a console environment. It guarantees that the same service can be reused safely and cleanly for web interfaces, REST APIs, or bots without any modification.
* **Security & Stability impact**: This prevents UI-specific bugs from crashing core business operations. It ensures that raw data handling and output formatting are completely isolated, making testing and debugging significantly more reliable.
