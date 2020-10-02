# Duke User Guide

Welcome to Duke! Duke is an intelligent personal assistant that can help you get organised, manage your tasks, and
 keep track of your busy life. 
 
Duke is a command-line application, designed for fast navigation and usage with fast, easy commands and an intuitive
 syntax. 

## Features 

### The Three types of Tasks

Duke supports three different types of Tasks: ToDos, Deadlines, and Events. 

#### ToDo

A ToDo is a simple type of task, that you plan to do, but don't really have a strict due date for. It just has a name.

#### Deadline

A Deadline is a task which needs to get done by a certain date. For example, most homework has due dates and as such
 would be ideal for storing as a Deadline. It has a name, and an associated due date/time. 
 
#### Event

An Event is a task which will be done at a certain date and time. For example, you may have a meeting with some
 colleagues at a certain time, and this should be stored as an Event. Like a Deadline, it has a name and an
  associated date and time. 
  
### Personal, unique messages

## Usage

### Adding new tasks

#### `todo` - Adding a new todo task

Add a new todo task, with a specified title. 

Syntax: `todo <taskname>`

Example of usage: 

```
todo learn to solve a rubik's cube
```

Expected outcome:

```
____________________________________________________________
Understood, chief. I've added the following to-do to your list: learn to solve a rubik's cube
____________________________________________________________
```

NB the message may be different as it is randomly generated :D

#### `event` - Adding a new event task

Add a new event, with a specified title and a date. If the date provided is in ISO8601 format, it will be added to
 the task list as a date, otherwise it will be added as a string of text. If it is added as a date, you will be able
  to find the task when searching for tasks before or at a certain date. 
  
  Syntax: `event <eventtitle> /at <date>`

Example of usage: 

```
event meet Prof /at 2020-10-10
```

Expected outcome:

```
____________________________________________________________
Of course, kahuna. I've added this event to your list: meet Prof
____________________________________________________________
```

NB the message may be different as it is randomly generated :D

#### `deadline` - Adding a new deadline

Add a new deadline, with a specified title and a due date. If the date provided is in ISO8601 format, it will be
 added to
 the task list as a date, otherwise it will be added as a string of text. If it is added as a date, you will be able
  to find the task when searching for tasks before or at a certain date. 

Example of usage: 

```
deadline submit iP /by 2020-10-02
```

Expected outcome:

```
____________________________________________________________
Understood, kahuna. Added a new deadline to your list, titled : submit iP
____________________________________________________________
```

NB the message may be different as it is randomly generated :D

### Finding existing tasks

#### `list` - List all the tasks added

Example of usage: 

```
list
```

Expected outcome:

```
____________________________________________________________
[T][ ] learn to solve a rubik's cube
[E][ ] meet Prof, at 10/10/2020
[D][ ] submit iP, at 02/10/2020
 ____________________________________________________________
```

#### `find` - Find all tasks matching a search key

Find all the tasks that contain a certain string of characters, the search key, in the task title. 

Syntax: `find <searchkey>` 

Example of usage: 

```
find rubik
```

Expected outcome:

```
____________________________________________________________
[T][ ] learn to solve a rubik's cube
____________________________________________________________
```

NB this will be different depending on the tasks you have added!

#### `before` - Find all tasks before a certain date

Find all the tasks before a certain date, specified in ISO8601 YYYY-MM-DD format. The tasks must have been added with
 a properly formatted date before. 

Syntax: `before YYYY-MM-DD`

Example of usage: 

```
before 2020-10-05
```

Expected outcome:

```
____________________________________________________________
[D][ ] submit iP, at 02/10/2020
____________________________________________________________
```

NB this will be different depending on the tasks you have added!

#### `at` - Find all tasks at a certain date

Find all the tasks before a certain date, specified in ISO8601 YYYY-MM-DD format. The tasks must have been added with
 a properly formatted date before. 

Example of usage: 

```
at 2020-10-10
```

Expected outcome:

```
____________________________________________________________
[E][ ] meet Prof, at 10/10/2020
____________________________________________________________
```

### Managing existing tasks

#### `done` - Mark a task as done

Mark the task at the specified position on the list as done. 

Syntax: `done <number>`

Example of usage: 

```
done 2
```

Expected outcome:

```
____________________________________________________________
Gotcha, kahuna. meet Prof marked as done.
____________________________________________________________
```

#### `delete` - Describe action

Delete at the specified position on the list. 

Syntax: `delete <number>`

Example of usage: 

```
delete 1
```

Expected outcome:

```
____________________________________________________________
Of course, kahuna. [T][ ] learn to solve a rubik's cube deleted. 
____________________________________________________________
```

### Others

#### `help` - Get help about Duke and learn the different commands

Example of usage: 

```
help
```

Expected outcome:

```
help
Here are all the commands I know. 
Adding a new to-do task: 
todo <todoname>
Adding a new event: 
event <eventname> /at <eventtime>
Adding a new deadline: 
deadline <deadlinename> /by <deadlineduedate>
Viewing all the tasks: 
list
Deleting a task: 
delete <tasknumber>
<tasknumber> represents the number associated with the task, as seen on screen. 
Marking a task as done: 
done <tasknumber>
<tasknumber> represents the number associated with the task, as seen on screen. 
Getting all tasks before a date: 
before YYYY-MM-DD
YYYY-MM-DD is the date before which you want to find tasks.
Getting all tasks at a date: 
at YYYY-MM-DD
YYYY-MM-DD is the date at which you want to find tasks.
Searching for tasks: 
find <key>
<key> represents whatever you want to search for. 
Accessing help: 
help
Quitting: 
bye
Read the full user guide at https://neilbaner.github.io/ip/
```

#### `bye` - Quit Duke and save your tasks

Example of usage: 

```
bye
```

Expected outcome:

```
____________________________________________________________
Bye. Hope to see you again soon!
Shutting down...
____________________________________________________________
```
