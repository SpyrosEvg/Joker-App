# Joker-App(Unfinished)
is a Spring MVC project

<h2>Introduction</h2>

 - </h3>Overview of the project</h3>
 This is an unfinished project that I am currently working on, this is a MVC project that takes JSON data from OPAP's Tzoker game web services and displays them.In future updates , these data will be stored in a database. Also, it will provide data visualization graphs and statistics.
 
 - <h3>Technologies Used :</h3>
    <ul>
      <li>Spring 
      <li>Jackson
      <li>Servlet
      <li>API
      <li>Jsp
      <li>Hibernate(future)
      <li>MySql(future)
      <li>Maven
      <li>Html
      <li>CSS(future)
     </ul>

<h2>Getting Started</h2>

<h3>Installation instructions</h3>
In order to see the project in action , First of all  , change the Prespective to Java EE then you will need eclipse with m2e plugin installed then in eclipse go to 
<Br>File->Import->Under Maven : Existing Maven Project -> Next -> <br>
Browse your computer to find the location of the unzipped project and hit Finish

<br> Also , you will need to install tomcat 9 , then you need to go in 
<br>File -> New -> Server or Other -> Under Server section choose Server -> Next -> Under Apache go to Tomcat 9.0 -> hit Next -> browse the location that you have installed Tomcat -> Finish

<h3>How to run the project</h3>

When all of the above have been done , to run the Program go to Joker-App -> Left click and Run as "Run on Server".

<h4>The project is up and running.</h4>


<h2>Usage</h2>

<h3>Home Page</h3>

In Home Page you have 3 options :

- SpecificDraw
- LastGame
- JokerMonth

In SpecificDraw you choose a number between 1 and the drawId of the LastGame.
In LastGame it shows the Last game.
In JokerMonth you choose a month and it shows all the games happend in this month.



<h3>Notes</h3>
In every game it shows GameId,Date,PrizeCategorie List and Winning List

<h3>In Future Updates</h3>
Some feature that will be incorporate:
- Data will be stored in database
- Data visualization 
- Export PDF with database bata
- Html/CSS embellish
