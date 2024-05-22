# Sistema Raizes de Minas	
#### Video Demo:  https://youtu.be/VHFyNdJbZGE?si=WF-WZr8IIQ5708kB
#### Description: Web App.Sales CRUD manager for my wife. Projected with Java, Spring, PostgreSQL.

    For my final project in CS50, I designed a web application that manages my wife sales of pao de queijo(something like a bread made of cheese). Her company is named "raizes de minas", that explains the name of the project.

    After some research, I decided to go with with Java because of the object oriented programming. I started studying with H. M. Deitel`s "Java How to Program". At the same time, learning about Spring framework and all his features.

    For IDE i used IntelliJ and VScode. 

    I used a lot of depencies in my spring file. Jdbc, jpa and postgre driver for the database; Lombok for  some getters and servers; Flyway for migrations; Thymeleaf for fron-back conversation. And Spring Boot for wrapping it all in a web app.

    Basically, I started creating a CRUD with a MVC design. Directories divided by Models, Controllers And Repositories.
    My principal models were Produtos, Clientes and Vendas(Products, Customer and Sales).

    For the models, we have "Cliente"(Customer), FormaDePagamento(a enum type for payment methods like card, money...), "ItemVenda"(for the iten sales list), "Produto"(products) and "Venda"(sale). I did'nt make things complex for now, but in the future I'll add more functions like making an Brazillian equivalent of "Sales Receipt" that takes to long for my wife to make manually. I made some getters and settes with lombok and some with the IDE's generator. intelliJ helps a lot in any situation.

    There are repositories for every model, made with interfaces for each one. Some needed a query made by me. The most  part of it works out of the box with Jpa and Jdbc. They make most of the job needed to conect the database with the app. 

    In the Controllers directory we have the set of maps for "GET"s and "POST"s endpoints. Basically, i had to pass throught ModelAndView class, objects with ".addObject" all of the repositories needed to build the tables in my frontend. Sometimes manipulating the repositories for adding or subtracting itens from my stock.

    Basics endpoints like "register{model}", "edit{model}", save{model} and "delete{model} were created in the controllers to manipulate my database when needed. 

    At times, i consulted the cs50 duck ai to get information about what notes to use like "@Controller", "@Service" or "@Autowired". As the days were passing, i got used to it and the duck was less necessary.

    For the front-end, I used basic Bootstrap stuff. Tables, forms, buttons and others. Some icons I got in FontAwesome.
    Tables includes a search input that works with JQuery and DataTables. It helps a lot when you need to find something in long  tables. Some JavaScript masks where required for telephone fields and others.

    For each model we have a directory in "templates" with a list.html and a register.html. All of them includes a <nav> with the endpoints for each. The templates are not quite clean, but this is something that needs atention in a short term. I pretend to use Angular for front after submitting my final project. 

    The color theme uses the colors of my wife's company, that are listed in the style.css. I tried to work with the Spring Security but it did'nt want to cooperate with me very much.
    Some of the images i wanted to use didn't worked as well. I don't really know why! The source adress seems fine.

    The sales register page needed a list of itens that is implemented by ItemVenda model. Everytime you add an item it refreshes the TotalValue and goes to a list where you can either edit the item or remove it, in case you added something wrong. It needed a lot of thinking and was one the hardest parts to implement. But looks to work very well right now.

    All the rows in the database can be edited by the front-end of the app. Making easy to correct mistakes. The app works with a simple interface and get the job done for the actual needs of my wife's company(it is a small one yet!)

    As the company grows, as do the needs. And I'm happy that my knowledge will keep improving as the time goes by! I'm Gustavo Caixeta, and this was CS50!

    ps.: Sorry for my english :/








    
