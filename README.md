# Java-GA-Scheduler
# A genetic algorithm to find the best schedule
Your job is to optimize the schedule using a genetic algorithm.  You should write a program that "evolves" the schedule by combining course CRNs with times and rooms.  Here are the rules for assigning class times and rooms to courses:

 

Hard rules: These rules cannot be broken.  That is, do not allow your algorithm to propose a solution that breaks these rules:

Courses that require a multimedia room must be assigned a multimedia room
Rooms must be large enough to accommodate the number of students enrolled.
A course (CRN) must only be on the schedule exactly 1 time.
Soft Rules:  These rules are suggestions and following them will improve fitness

Professors do not want to teach 3 or more courses in a row.
Professors like teaching multiple courses in the same room.
Professors typically do not want a large amount of time between their starting and ending class.
Fitness bonuses and penalties

Subtract 1 point for each seat available that is not taken.
Subtract 15 points for each delay of 3 or more hours between courses.
Subtract 10 points for each instance a professor has 3 or more courses in a row.  ( Three courses in a row would subtract 10 points.   Four courses in row would subtract 20 points.)
Add 5 points for each instance that a room is duplicated past the first room for a professor:  (Eg. Black214, Black214 is a 5pt bonus.     Kreb206, Kreb206, Kreb206 is a 10pt bonus.)
Guidelines for the genetic algorithm:

Follow hard rules when formulating an individual in a population.  That is, do not allow a candidate into population of solutions that breaks any of the hard rules.
Compute the fitness of a schedule schedule by summing up the scores for each course/time/room combination. 
Use conservative values for N (population size = 50), Pc (crossover probability =0.75), Pm ( mutation probability = 0.05). 
