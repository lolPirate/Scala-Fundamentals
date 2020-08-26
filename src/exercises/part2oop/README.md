# Questions for OOP

## Question 1 : Novel and a Writer
* <b>Writer</b> : firstName: String, lastName: String, year: Int
    * Methods
        * fullName: String = Returns the firstName concatenated with lastName using a space
* <b>Novel</b> : name: String, yearOfRelease: Int, author: Writer
    * Methods
        * authorAge: Int = Returns the age of the author at the time the novel was published
        * isWrittenBy(author: Writer): Boolean = checks if the two authors are the same
        * copy(newYearOfRelease: Int): Novel = returns a revised copy of the book updated with new year of release
        
## Question 2 : Counter
* <b>Counter</b> : number: Int
    * Methods
        * currentCount(): Int = Returns the current value of counter
        * increment(): Counter = Increments counter by 1 and returns new Counter
        * increment(by: Int): Counter = Increments counter by "by" and returns new Counter
        * decrement(): Counter = Decrements counter by 1 and returns new Counter
        * decrement(by: Int): Counter = Decrements counter by "by" and returns new Counter
   