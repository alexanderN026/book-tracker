# Book Tracker

## Preview

***

![Preview Image Book Tracker](Preview%20book-tracker.png)

## Description

***

The client, through a web browser interface, sends and receives HTTP requests to 'books' table in a MySQL database

* These requests are processed by the backend server, which contains the logic for routing the request to the appropriate endpoint for processing
* The HTML, CSS, and JavaScript files create the frontend of the application, allowing users to initiate and visualize these requests and responses directly in the browser
* Once a request is made from the frontend, the server processes it, performs the necessary actions on the MySQL database, and returns a response to the client
* This response is then received and displayed by the browser, providing an interactive interface for the user
* The frontend dynamically updates based on these responses, facilitating a smooth user experience

To access and interact with the application, users can navigate to http://localhost:8080/books in their web browser

## Setup of the application.properties file

***

To change the password for the database, you can either set it in IntelliJ IDEA's Run/Debug Configurations Environment
variables or change the value of ${DATABASE_PASSWORD} to your chosen password

`spring.datasource.password=${DATABASE_PASSWORD}`

## Setup of the MySQL database management system

***

* Download and install MySQL
* Give the root user your chosen password during installation
* Use MySQL workbench or IntelliJ IDEA to create the database or schema `book_tracker`
* Start the application, this creates the table

Add these 5 entries to the table with the following query:

`INSERT INTO books (author, isbn, publish_year, title, image_url)`\
`VALUES`\
`('Emma Mayers', '8922800353410', '2011', 'The Bike Guy', 'https://img.freepik.com/free-vector/bike-guy-wattpad-book-cover_23-2149452163.jpg?w=826&t=st=1686125795~exp=1686126395~hmac=f4fe1495af2253c550af5f652b779d4c7b1421ae55666766817026e6961b9103'),`\
`('J. SAMUEL HERSEINGTH', '1369057380443', '2018', 'Snow at sunset', 'https://img.freepik.com/free-vector/abstract-monocolor-winter-book-cover_23-2148801464.jpg?w=826&t=st=1686126014~exp=1686126614~hmac=bef06e3c7ded0da3ef71323c6e6cd4b7465e8eb219bffc28a0f069c5c1d391d3'),`\
`('Mia Jackson', '9976863935367', '2005', 'Different Winter', 'https://img.freepik.com/free-vector/abstract-elegant-winter-book-cover_23-2148798745.jpg?w=826&t=st=1687178738~exp=1687179338~hmac=fd13a93924dfd2ebf8f60caa6103ab3ed117cb730d666ba4883866d9a276ab40'),`\
`('Marissa Pullman', '2967364289062', '2020', 'New Educators', 'https://img.freepik.com/free-vector/creative-innovative-education-book-cover_23-2149410117.jpg?w=826&t=st=1687179029~exp=1687179629~hmac=4b037620cc5d470f0b77d038d23839e8d95e551f636bbdb1c4b5edea835aa86d'),`\
`('Dani Murdor', '1325898850218', '2013', 'The best tips of design', 'https://img.freepik.com/free-vector/abstract-colorful-design-book-cover_23-2148886968.jpg?w=826&t=st=1687179519~exp=1687180119~hmac=b0ccd8f3a284c9cc1f367693d781038dae495d36dce28cac004f3e790755d486');`

