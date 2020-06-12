# Jindexer

In this indexer you just need to fill a table with links, and then, the documents of those links will be indxed


## Prerequisites

* Create a database for this project 

## Getting Started

* Clone the repo
* Import all external libraries in the directory <ins>libs</ins>
* Make the <ins>working directory</ins> of the file <ins>Indexer.java</ins> to be the directory <ins>resources</ins>
* Change the values of the variables <ins>USER, PASS and DATA_BASE_NAME</ins> in the file of <ins>src/data_base/DataBase</ins> according to your information
* Fill the table of <ins>crawler_urls</ins> with links which will be indexed
* Run the file of <ins>Indexer.java</ins>
* Enjoy!



## Running the tests

You can use the file of <ins>InsertIndexer.java</ins> as a test to add some urls in the table of <ins>crawler_urls</ins>
and some **hosts** to the table **hosts_popularity** -used to calculate the popularity for each host-

### Steps:

* Add links and hosts
    * Example
![Add links and hosts](https://github.com/SofyanMahmoud0000/Buffer/blob/master/Addlinks.png)

* Run the file of <ins>InsertIndexer.java</ins>
* Run the file of <ins>Indexer</ins>

## Database diagram
![Database diagram](https://github.com/sofyanmahmoud0000/Buffer/blob/master/DataBaseDiagram.png) 

## Built With

* [Java](https://www.geeksforgeeks.org/java/) - The language used
* [Jsoup](https://github.com/jhy/jsoup) - The library of Java html parser 
* [Jstemmer](https://github.com/sofyanmahmoud0000/Jstemmer) - The stemmer used to stem the strings 

## Development and support

If you have any questions on how to use this indexer, or have ideas for future development, please send me an e-mail to ***sofyan1020@gmail.com***.


## Licence 
MIT

## Authors

**Sofyan Mahmoud** - computer engineer

