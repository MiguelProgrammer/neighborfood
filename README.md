Through the monolith, I will create an application similar to Ifood.

This application is being developed to prove theories, software development with DDD, every flow developed here is intended only to put into technical practices of domais driven design, I will use docker to upload the application to the PostgreSql database.

We will apply the techniques to a monolith pattern to understand in practice the importance of clean architectural design beyond project patterns.

We know that exagonal architecture preaches business agnostic to frameworks and technologies, however, I use the benefit of spring to completely create this project and in the end I will decouple it from the technologies used.

Thinking in a pragmatic way, I see this definition of exagonal architecture as at least indifferent, think about it, it preaches the non-relationship with the technology used but depends on others for its purpose to be served, it's a kind of I want you here, but even give me help. LOL

* Doc miro: <a href="https://miro.com/app/board/uXjVKUqbA08=/?share_link_id=950297951149">miro</a>
* Json doc to postman requests: <a href="https://drive.google.com/file/d/1TWaAGA2xTvNSnQcp9lHkM5kDRuydpQWx/view?usp=sharing">request postman</a>
<hr>

NEIGHBORFOOD MENU

* 1 - Register as admin
** 1.1 - If a user accesses the system and uses areas such as listing the menu or placing an order, the response will be empty and a
    notification will be sent to admin
* 2 - Register items in stock
  * 2.1 - The administrator can register one item per category per batch
   2.2 - When the customer places an order, the item selected in the order is subtracted from stock
* 3 - Register as a Customer
  * 3.1 - You can register using your name, email and CPF, if you don't want to, you will be identified by the order number
   3.2 - When registering and already having a login, the system will return your current username
* 4 - Log in as a customer
* 5 - List the options menu
* 6 - Place an order
  * 6.1 - If there is a product missing, the system will notify the customer and the administrative area for replacement
* 7 - Make payment
* 8 - Collect your order
* 9 - Receive treats
  * 9.1 - You will receive discount alerts on upcoming orders
