##Lightweight javac @Warning annotation

FAQ:

Q: ***What @Warning annotation is for?***

A: For throwing warning messages from javac.

Q: ***When I can use it?***

A: When you want to mark some piece of code as "dangerous" or "unstable", etc.

Q: ***Why not // TODO or FIXME, etc?*** 

A: Because they don't throw compile time warnings by default

Q: ***What is the size of the library?*** 

A: About 3kb, only two classes: @Warning annotation and annotation processor.

------------------------------
**Usage is very very simple:**

    // some code...
    
    @Warning("This method should be refactored")
    public void someCodeWhichYouNeedAtTheMomentButYouWantToRefactorItLater() {
        // bad stuff going on here...
    }
