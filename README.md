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